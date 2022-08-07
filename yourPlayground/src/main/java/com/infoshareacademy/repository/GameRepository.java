package com.infoshareacademy.repository;

import com.infoshareacademy.model.Game;
import com.infoshareacademy.model.Location;
import com.infoshareacademy.model.Player;
import com.infoshareacademy.utils.GameType;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class GameRepository extends FakeRepository<Integer, Game> {

    private final AtomicInteger nextId = new AtomicInteger(1);
    private final AtomicInteger nextElementId = new AtomicInteger(1);

    @PostConstruct
    public void initDb() {

        Player jan = new Player("Jan", "J@n");
        Player pawel = new Player("Paweł", "P@weł");
        Set<Player> players = new HashSet<>();
        players.add(jan);
        players.add(pawel);

        Game football = new Game();
        football.setName("Football");
        football.setType(GameType.SPORTS);
        football.setGameLocation(new Location(55.12, 12.32, "Warsaw"));
        football.setMaxNumberOfPlayers(22);
        football.setGameOwner(jan);
        football.setPlayers(players);

        Game chess = new Game();
        football.setName("Chess");
        football.setType(GameType.BOARD);
        football.setGameLocation(new Location(55.12, 12.32, "Łódź"));
        football.setMaxNumberOfPlayers(2);
        football.setGameOwner(pawel);
        football.setPlayers(players);
    }

    public void save(Game entity) {
        super.save(entity);
    }

    @Override
    Integer nextId() {
        return nextId.getAndIncrement();
    }
}
