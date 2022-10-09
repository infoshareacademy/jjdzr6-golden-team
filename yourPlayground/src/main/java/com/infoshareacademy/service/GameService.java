package com.infoshareacademy.service;

import com.infoshareacademy.dto.*;
import com.infoshareacademy.entity.Game;
import com.infoshareacademy.entity.Location;
import com.infoshareacademy.entity.Player;
import com.infoshareacademy.exceptions.GameIsFullException;
import com.infoshareacademy.exceptions.GameNotFoundException;
import com.infoshareacademy.exceptions.PlayerNotFoundException;
import com.infoshareacademy.mappers.GameMapper;
import com.infoshareacademy.repository.GameDao;
import com.infoshareacademy.repository.GameRepository;
import com.infoshareacademy.repository.LocationRepository;
import com.infoshareacademy.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;
    private final GameDao gameDao;
    private final LocationRepository locationRepository;

    private final PlayerRepository playerRepository;
    private final GameMapper gameMapper;


    public void create(CreateGameDto createGameDto) {

        if (locationRepository.findByTown(createGameDto.getTown()).isEmpty()) {
            Location location = new Location(0.00, 0.00, createGameDto.getTown());
            locationRepository.save(location);
        }

        GameDto dto = gameMapper.fromCreateGameDtoToGameDto(createGameDto);
        Game game = gameMapper.toEntity(dto);

        gameRepository.save(game);
    }

    @Transactional
    public void joinGame(JoinGameDto joinGameDto, PlayerDto playerDto) throws GameNotFoundException, PlayerNotFoundException {
        Game game = gameRepository.findById(joinGameDto.getId())
                .orElseThrow(() -> new GameNotFoundException("Could not find game with ID: " + joinGameDto.getId()));
        if (game.getPlayersSize() >= game.getMaxNumberOfPlayers()) throw new GameIsFullException();

        Player player = playerRepository.findByUsername(playerDto.getUsername())
                .orElseThrow(() -> new PlayerNotFoundException("Could not find player with Username: " + playerDto.getUsername()));
        game.getPlayers().add(player);
        gameRepository.save(game);
    }

    @Transactional
    public void deleteGame(Integer id) {
        gameRepository.deleteById(id);
    }

    @Transactional
    public void editGame(GameDto gameDto ,Integer id) {
        Optional<Game> byId = gameRepository.findById(id);

        if(byId.isPresent()) {
            Game game = byId.get();
            game.setType(gameDto.getType());
            game.setName(gameDto.getName());
            game.setMaxNumberOfPlayers(gameDto.getMaxNumberOfPlayers());
            game.setDateOfGame(gameDto.getDateOfGame());

            Location gameLocation = game.getGameLocation();
            gameLocation.setTown(gameDto.getGameLocation().getTown());

        }

    }

    public GameDto findById(Integer id) throws GameNotFoundException {
        Optional<Game> game = gameRepository.findById(id);
        if (game.isPresent()) {
            return gameMapper.toDto(game.get());
        } else throw new GameNotFoundException(
                "Could not find game with ID: " + id);
    }

    public List<GameDto> findAll() {
        Collection<Game> games = gameRepository.findAll();
        return games.stream()
                .map(gameMapper::toDto).toList();

    }

    public List<GameDto> findAllInFuture() {
        Collection<Game> games = gameRepository.findAll();
        return games.stream()
                .filter(g -> g.getDateOfGame().isAfter(LocalDateTime.now()))
                .map(gameMapper::toDto).toList();

    }

    public List<GameDto> findAllByOwner(Player player) {
        Collection<Game> games = gameRepository.findAllByGameOwner(player);

        return games.stream()
                .map(gameMapper::toDto).toList();
    }

    public Object findAllInFutureByOwner(Player player) {
        Collection<Game> games = gameRepository.findAllByGameOwner(player);

        return games.stream()
                .filter(g -> g.getDateOfGame().isAfter(LocalDateTime.now()))
                .map(gameMapper::toDto).toList();
    }

    public Object findAllInPastByOwner(Player player) {
        Collection<Game> games = gameRepository.findAllByGameOwner(player);

        return games.stream()
                .filter(g -> g.getDateOfGame().isBefore(LocalDateTime.now()))
                .map(gameMapper::toDto).toList();
    }


    public List<GameDto> findByCriteriaBuilder(FindGameDto findGameDto) {
        Collection<Game> foundGames = gameDao.findGamesByCriteriaBuilder(findGameDto);
        return foundGames.stream()
                .map(gameMapper::toDto)
                .filter(g -> g.getDateOfGame().isAfter(LocalDateTime.now()))
                .toList();
    }


    public int getMaxNumberOfPlayersById(Integer id) {
       if (gameRepository.findById(id).isPresent()) {
           return gameRepository.findById(id).get().getMaxNumberOfPlayers();
       } else return 0;
    }


}
