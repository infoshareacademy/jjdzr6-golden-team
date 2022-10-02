package com.infoshareacademy.repository;

import com.infoshareacademy.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
    @Transactional
    Optional<Player> findByUsername(String username);

}
