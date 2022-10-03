package com.infoshareacademy.repository;

import com.infoshareacademy.entity.Game;
import com.infoshareacademy.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {
    Collection<Game> findAllByGameOwner(Player player);
}
