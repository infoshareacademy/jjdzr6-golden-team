package com.infoshareacademy.service;

import com.infoshareacademy.dto.*;
import com.infoshareacademy.entity.Game;
import com.infoshareacademy.entity.Location;
import com.infoshareacademy.entity.Player;
import com.infoshareacademy.mappers.GameMapper;
import com.infoshareacademy.mappers.PlayerMapper;
import com.infoshareacademy.repository.GameDao;
import com.infoshareacademy.repository.GameRepository;
import com.infoshareacademy.repository.LocationRepository;
import com.infoshareacademy.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;
    private final GameDao gameDao;
    private final LocationRepository locationRepository;

    private final PlayerRepository playerRepository;
    private final GameMapper gameMapper;
    private final PlayerMapper playerMapper;


    public void create(CreateGameDto createGameDto) {

        if (locationRepository.findByTown(createGameDto.getTown()).isEmpty()) {
            Location location = new Location(0.00, 0.00, createGameDto.getTown());
            locationRepository.save(location);
        }

        GameDto dto = gameMapper.fromCreateGameDtoToGameDto(createGameDto);
        Game game = gameMapper.toEntity(dto);

        gameRepository.save(game);
    }

    public void joinGame(JoinGameDto joinGameDto, PlayerDto playerDto) {
        Game game = gameRepository.findById(joinGameDto.getId()).get();

        if(game.getPlayers().size() < game.getMaxNumberOfPlayers()) {
            Set<Player> players = game.getPlayers();
            players.add(playerRepository.findByUsername(playerDto.getUsername()).get());
            game.setPlayers(players);

            gameRepository.save(game);
        }
    }

    public void deleteGame(Integer id) {
        gameRepository.deleteById(id);
    }

    public GameDto findById(Integer id) {
        Optional<Game> game = gameRepository.findById(id);
        return gameMapper.toDto(game.get());
    }

    public List<GameDto> findAll() {
        Collection<Game> games = gameRepository.findAll();
        return games.stream()
                .map(gameMapper::toDto)
                .collect(Collectors.toList());

    }

    public List<GameDto> findAllByOwner(Player player) {
        Collection<Game> games = gameRepository.findAllByGameOwner(player);

        return games.stream()
                .map(gameMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<GameDto> findByCriteriaBuilder(FindGameDto findGameDto) {
        Collection<Game> foundGames = gameDao.findGamesByCriteriaBuilder(findGameDto);
        return foundGames.stream()
                .map(gameMapper::toDto)
                .collect(Collectors.toList());
    }


}
