package com.infoshareacademy.mappers;

import com.infoshareacademy.dto.CreateGameDto;
import com.infoshareacademy.dto.GameDto;
import com.infoshareacademy.entity.Game;
import com.infoshareacademy.entity.Location;
import com.infoshareacademy.repository.LocationRepository;
import com.infoshareacademy.repository.PlayerRepository;
import com.infoshareacademy.utils.GameType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
public class GameMapper {
    private final LocationRepository locationRepository;
    private final PlayerMapper playerMapper;

    private final PlayerRepository playerRepository;

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
                .dateOfGame(createGameDto.getDateOfGame())
                .gameOwner(createGameDto.getGameOwner())
                .players(new HashSet<>(List.of(createGameDto.getGameOwner())))
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
                .gameOwner(playerMapper.toDto(game.getGameOwner()))
                .players(game.getPlayers().stream()
                        .map(playerMapper::toDto)
                        .collect(Collectors.toSet()))
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
                .gameOwner(playerRepository.findByUsername(gameDto.getGameOwner().getUsername()).get())
                .players(gameDto.getPlayers().stream()
                        .map(e-> playerRepository.findByUsername(e.getUsername()).get())
                        .collect(Collectors.toSet()))
                .build();
    }
}
