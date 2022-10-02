package com.infoshareacademy.mappers;

import com.infoshareacademy.dto.CreateGameDto;
import com.infoshareacademy.dto.GameDto;
import com.infoshareacademy.dto.PlayerDto;
import com.infoshareacademy.entity.Game;
import com.infoshareacademy.entity.Location;
import com.infoshareacademy.entity.Player;
import com.infoshareacademy.repository.LocationRepository;
import com.infoshareacademy.utils.GameType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
public class GameMapper {
    private final LocationRepository locationRepository;
    private final PlayerMapper playerMapper;

    public GameDto fromCreateGameDtoToGameDto(CreateGameDto createGameDto) {

        Location location;

        if(locationRepository.findByTown(createGameDto.getTown()).isPresent()) {
            location = locationRepository.findByTown(createGameDto.getTown()).get();
        } else {
            location = new Location(0.00, 0.00, createGameDto.getTown());
        }

        return GameDto.builder()
                .name(createGameDto.getName())
                .type(GameType.valueOf(createGameDto.getType()))
                .maxNumberOfPlayers(createGameDto.getMaxNumberOfPlayers())
                .gameLocation(location)
                .build();
    }

    public GameDto toDto(Game game) {
        return GameDto.builder()
                .id(game.getId())
                .name(game.getName())
                .type(game.getType())
                .maxNumberOfPlayers(game.getMaxNumberOfPlayers())
                .dateOfGame(game.getDateOfGame())
                .gameLocation(game.getGameLocation())
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
        return Game.builder()
                .id(gameDto.getId())
                .name(gameDto.getName())
                .type(gameDto.getType())
                .maxNumberOfPlayers(gameDto.getMaxNumberOfPlayers())
                .dateOfGame(gameDto.getDateOfGame())
                .gameLocation(gameDto.getGameLocation())
                .gameOwner(gameDto.getGameOwner())
                .players(gameDto.getPlayers().stream()
                        .map(dto -> {
                            Player player = new Player();
                            player.setId(dto.getId());
                            player.setUsername(dto.getUsername());
                            return player;
                        }).collect(Collectors.toSet()))
                .build();
    }
}
