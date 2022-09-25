package com.infoshareacademy.repository;

import com.infoshareacademy.entity.Game;
import com.infoshareacademy.utils.GameType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.*;
import java.util.List;

public interface GameRepository extends JpaRepository<Game, Integer> {

    default List<Game> findByDateOfGame(LocalDate localDate) {
        return findGamesByDateOfGameBetween(localDate.atStartOfDay(), localDate.plusDays(1).atStartOfDay());
    }

    List<Game> findGamesByName(String name);
    List<Game> findGamesByType(GameType gameType);
    List<Game> findGamesByGameLocation_Town(String town);
    List<Game> findGamesByDateOfGameBetween(LocalDateTime from, LocalDateTime to);


}