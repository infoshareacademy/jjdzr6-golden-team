package com.infoshareacademy.mappers;

import com.infoshareacademy.dto.GameDto;
import com.infoshareacademy.dto.PlayerDto;
import com.infoshareacademy.entity.Game;
import com.infoshareacademy.entity.Location;
import com.infoshareacademy.entity.Player;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import java.util.stream.Collectors;
import java.util.List;


@Component
public class GameMapper {

    public GameDto toDto(Game game) {
        return GameDto.builder()
                .id(game.getId())
                .name(game.getName())
                .type(game.getType())
                .maxNumberOfPlayers(game.getMaxNumberOfPlayers())
                .dateTime(game.getDateOfGame())
                .town(game.getGameLocation().getTown())
                .latitude(game.getGameLocation().getLatitude())
                .longitude(game.getGameLocation().getLongitude())
                .gameOwner(game.getGameOwner())
                .players(game.getPlayers().stream()
                        .map(entity -> {
                            PlayerDto playerDto = new PlayerDto();
                            playerDto.setId(entity.getId());
                            playerDto.setUsername(entity.getUsername());
                            return playerDto;
                        }).collect(Collectors.toSet()))
                .build();
    }

    public Game toEntity(GameDto gameDto) {
        Game game = Game.builder()
                .id(gameDto.getId())
                .name(gameDto.getName())
                .type(gameDto.getType())
                .maxNumberOfPlayers(gameDto.getMaxNumberOfPlayers())
                .dateOfGame(gameDto.getDateTime())
                .gameLocation(new Location(gameDto.getLongitude(),
                        gameDto.getLatitude(),
                        gameDto.getTown()))
                .gameOwner(gameDto.getGameOwner())
                .players(gameDto.getPlayers().stream()
                        .map(dto -> {
                            Player player = new Player();
                            player.setId(dto.getId());
                            player.setUsername(dto.getUsername());
                            return player;
                        }).collect(Collectors.toSet()))
                .build();

        return game;
    }
}
