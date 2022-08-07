package com.infoshareacademy.mappers;

import com.infoshareacademy.dto.GameDto;
import com.infoshareacademy.model.Game;
import com.infoshareacademy.model.Location;
import com.infoshareacademy.model.Player;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Component
public class GameMapper {

    public GameDto toDto(Game game) {
        return GameDto.builder()
                .id(game.getId())
                .name(game.getName())
                /*.type(game.getType())*/
                .maxNumberOfPlayers(game.getMaxNumberOfPlayers())
                /*.date(LocalDate.of(game.getDateOfGame().getYear(),
                        game.getDateOfGame().getMonth(),
                        game.getDateOfGame().getDayOfMonth()))
                .time(LocalTime.of(game.getDateOfGame().getHour(),
                        game.getDateOfGame().getMinute()))*/
                .town(game.getGameLocation().getTown())
                .latitude(game.getGameLocation().getLatitude())
                .longitude(game.getGameLocation().getLongitude())
                .playerName(game.getGameOwner().getName())
                .email(game.getGameOwner().getMail())
                //players to tak jak elements
                /*.players(game.getPlayers())*/
                .build();
    }

    public Game toEntity(GameDto gameDto) {
        System.out.println(gameDto);

        Game game = Game.builder()
                .id(gameDto.getId())
                .name(gameDto.getName())
                /*.type(gameDto.getType())*/
                .maxNumberOfPlayers(gameDto.getMaxNumberOfPlayers())
                .dateOfGame(LocalDateTime.of(LocalDate.parse(gameDto.getDate()),
                        LocalTime.parse(gameDto.getTime())))
                .gameLocation(new Location(gameDto.getLongitude(),
                        gameDto.getLatitude(),
                        gameDto.getTown()))
                .gameOwner(new Player(gameDto.getPlayerName(),
                        gameDto.getEmail()))
                /*.players(gameDto.getPlayers())*/
                .build();

        System.out.println(game);
        return game;
    }
}
