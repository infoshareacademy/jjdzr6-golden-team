package com.infoshareacademy.mappers;

import com.infoshareacademy.dto.GameDto;
import com.infoshareacademy.model.Game;
import org.springframework.stereotype.Component;

@Component
public class GameMapper {

    public GameDto toDto(Game game) {
        return GameDto.builder()
                .name(game.getName())
                .build();
    }

    public Game toEntity(GameDto gameDto) {
        return Game.builder()
                .name(gameDto.getName())
                .build();
    }
}
