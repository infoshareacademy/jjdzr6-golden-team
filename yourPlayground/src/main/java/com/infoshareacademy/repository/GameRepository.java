package com.infoshareacademy.repository;

import com.infoshareacademy.entity.Game;
import com.infoshareacademy.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Collection;

public interface GameRepository extends JpaRepository<Game, Integer> {

    @Transactional
    Collection<Game> findAllByGameOwner(Player player);
}
