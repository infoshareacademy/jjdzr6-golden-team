package com.infoshareacademy.repository;

import com.infoshareacademy.entity.Game;
import com.infoshareacademy.entity.Location;
import com.infoshareacademy.utils.GameType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GameRepository extends JpaRepository<Game, Integer> {
    Optional<Game> findGameByType(GameType type);
    Optional<Game> findGameByName(String name);
    Optional<Game> findGameByGameLocation(Location gameLocation);
}
