package com.infoshareacademy.service;

import com.infoshareacademy.dto.GameDto;
import com.infoshareacademy.mappers.GameMapper;
import com.infoshareacademy.model.Game;
import com.infoshareacademy.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameServiceTH {

    private final GameRepository gameRepository;

    private final GameMapper gameMapper;

    @Autowired
    public GameServiceTH(GameRepository gameRepository, GameMapper gameMapper) {
        this.gameRepository = gameRepository;
        this.gameMapper = gameMapper;
    }

    public void create(GameDto dto) {
       Game game = gameMapper.toEntity(dto);
       gameRepository.save(game);
    }

    public GameDto find(Integer id) {
        Game game = gameRepository.findById(id);
        return gameMapper.toDto(game);
    }

    public List<GameDto> findAll() {
        Collection<Game> games = gameRepository.findAll();
        return games.stream()
                .map(gameMapper::toDto)
                .collect(Collectors.toList());

    }
}
