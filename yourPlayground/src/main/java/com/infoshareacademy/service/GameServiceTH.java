package com.infoshareacademy.service;

import com.infoshareacademy.dto.GameDto;
import com.infoshareacademy.entity.Player;
import com.infoshareacademy.mappers.GameMapper;
import com.infoshareacademy.entity.Game;
import com.infoshareacademy.mappers.PlayerMapper;
import com.infoshareacademy.repository.GameRepository;
import com.infoshareacademy.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GameServiceTH {

    private final GameRepository gameRepository;

    private final LocationRepository locationRepository;

    private final GameMapper gameMapper;

    private final PlayerMapper playerMapper;


    public void create(GameDto dto, Player owner) {

        if (dto.getGameLocation().getId() == null) {
            locationRepository.save(dto.getGameLocation());
        }

        dto.setPlayers(new HashSet<>(List.of(playerMapper.toDto(owner))));
        Game game = gameMapper.toEntity(dto);
        game.setGameOwner(owner);

        gameRepository.save(game);
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
}
