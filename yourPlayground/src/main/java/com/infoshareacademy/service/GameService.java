package com.infoshareacademy.service;

import com.infoshareacademy.dto.*;
import com.infoshareacademy.entity.Game;
import com.infoshareacademy.entity.Location;
import com.infoshareacademy.entity.Player;
import com.infoshareacademy.exceptions.GameNotFoundException;
import com.infoshareacademy.exceptions.PlayerNotFoundException;
import com.infoshareacademy.mappers.GameMapper;
import com.infoshareacademy.repository.GameDao;
import com.infoshareacademy.repository.GameRepository;
import com.infoshareacademy.repository.LocationRepository;
import com.infoshareacademy.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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

    public void joinGame(JoinGameDto joinGameDto, PlayerDto playerDto) throws GameNotFoundException, PlayerNotFoundException {
        Game game;
        if (gameRepository.findById(joinGameDto.getId()).isPresent()) {
            game = gameRepository.findById(joinGameDto.getId()).get();

            if(game.getPlayers().size() < game.getMaxNumberOfPlayers()) {
                Set<Player> players = game.getPlayers();
                if(playerRepository.findByUsername(playerDto.getUsername()).isPresent()) {
                    players.add(playerRepository.findByUsername(playerDto.getUsername()).get());
                    game.setPlayers(players);
                } else throw new PlayerNotFoundException(
                        "Could not find player with Username: " + playerDto.getUsername());

                gameRepository.save(game);
            }
        } else throw new GameNotFoundException(
                "Could not find game with ID: " + joinGameDto.getId());
    }

    public void deleteGame(Integer id) {
        gameRepository.deleteById(id);
    }

    public GameDto findById(Integer id) throws GameNotFoundException {
        Optional<Game> game = gameRepository.findById(id);
        if(game.isPresent()) {
            return gameMapper.toDto(game.get());
        } else throw new GameNotFoundException(
                "Could not find game with ID: " + id);
    }

    public List<GameDto> findAll() {
        Collection<Game> games = gameRepository.findAll();
        return games.stream()
                .map(gameMapper::toDto).toList();

    }

    public List<GameDto> findAllByOwner(Player player) {
        Collection<Game> games = gameRepository.findAllByGameOwner(player);

        return games.stream()
                .map(gameMapper::toDto).toList();
    }

    public List<GameDto> findByCriteriaBuilder(FindGameDto findGameDto) {
        Collection<Game> foundGames = gameDao.findGamesByCriteriaBuilder(findGameDto);
        return foundGames.stream()
                .map(gameMapper::toDto).toList();
    }


}
