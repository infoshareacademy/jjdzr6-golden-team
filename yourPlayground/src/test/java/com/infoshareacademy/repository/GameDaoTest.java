package com.infoshareacademy.repository;

import com.infoshareacademy.dto.CreateGameDto;
import com.infoshareacademy.dto.FindGameDto;
import com.infoshareacademy.dto.GameDto;
import com.infoshareacademy.dto.PlayerDto;
import com.infoshareacademy.entity.Game;
import com.infoshareacademy.entity.Player;
import com.infoshareacademy.entity.Role;
import com.infoshareacademy.mappers.PlayerMapper;
import com.infoshareacademy.service.GameService;
import com.infoshareacademy.service.PlayerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class GameDaoTest {

    @Autowired
    private GameService gameService;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private PlayerMapper playerMapper;

    @Test
    void findGamesByCriteriaBuilder() {

        //given
        FindGameDto findGameDto = new FindGameDto("Koszykówka",
                "Sport game",
                "Warszawa",
                LocalDate.of(2022, 10, 2));
        FindGameDto findGameDto1 = new FindGameDto("Koszykówka", null, null, null);
        FindGameDto findGameDto2 = new FindGameDto("Koszykówka", "Sport game", null, null);
        FindGameDto findGameDto3 = new FindGameDto("Koszykówka", "Sport game", "Warszawa", null);
        FindGameDto findGameDto4 = new FindGameDto("Koszykówka", null, "Warszawa", null);
        FindGameDto findGameDto5 = new FindGameDto("Koszykówka", null, null, LocalDate.of(2022, 10, 2));
        FindGameDto findGameDto6 = new FindGameDto(null, null, "Warszawa", LocalDate.of(2022, 10, 2));
        FindGameDto findGameDto7 = new FindGameDto(null, null, null, null);

        playerService.savePlayer(new PlayerDto(101, "test_user"));

        PlayerDto gameOwner = playerService.findByUsername("test_user");

        CreateGameDto game1 = new CreateGameDto("Koszykówka",
                "Sport game", 22,
                "Warszawa", LocalDateTime.of(2022, 10, 2, 12, 00), gameOwner);

        CreateGameDto game2 = new CreateGameDto("Koszykówka",
                "Sport game", 22,
                "Łodź", LocalDateTime.of(2022, 10, 23, 13, 00), gameOwner);

        CreateGameDto game3 = new CreateGameDto("Piłka nożna",
                "Board game", 22,
                "Warszawa", LocalDateTime.of(2022, 10, 2, 12, 00), gameOwner);

        gameService.create(game1, playerMapper.toEntity(gameOwner));
        gameService.create(game2, playerMapper.toEntity(gameOwner));
        gameService.create(game3, playerMapper.toEntity(gameOwner));


        //when
        List<GameDto> foundGames = gameService.findByCriteriaBuilder(findGameDto);
        List<GameDto> foundGames1 = gameService.findByCriteriaBuilder(findGameDto1);
        List<GameDto> foundGames2 = gameService.findByCriteriaBuilder(findGameDto2);
        List<GameDto> foundGames3 = gameService.findByCriteriaBuilder(findGameDto3);
        List<GameDto> foundGames4 = gameService.findByCriteriaBuilder(findGameDto4);
        List<GameDto> foundGames5 = gameService.findByCriteriaBuilder(findGameDto5);
        List<GameDto> foundGames6 = gameService.findByCriteriaBuilder(findGameDto6);
        List<GameDto> foundGames7 = gameService.findByCriteriaBuilder(findGameDto7);

        //then
        assertEquals(foundGames, List.of(game1));
        assertEquals(foundGames1, List.of(game1, game2));
        assertEquals(foundGames2, List.of(game1, game2));
        assertEquals(foundGames3, List.of(game1));
        assertEquals(foundGames4, List.of(game1));
        assertEquals(foundGames5, List.of(game1));
        assertEquals(foundGames6, List.of(game1, game3));
        assertEquals(foundGames7, List.of(game1, game2, game3));


    }

}