package com.infoshareacademy.model;

import com.google.gson.GsonBuilder;
import com.infoshareacademy.service.GameServiceImpl;
import com.infoshareacademy.utils.GameType;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)

public class Game extends GameServiceImpl {
    // Fields
    private String name;
    private GameType type;
    private int maxNumberOfPlayers;
    private Set<Player> players;
    private Location gameLocation;
    private LocalDateTime dateOfGame;
    private Player gameOwner;

    // Constructor
    public Game() {
        this.setPlayers(new HashSet<>());
    }

    public Game(String name, int maxNumberOfPlayers, GameType gameType) {
        this.name = name;
        this.maxNumberOfPlayers = maxNumberOfPlayers;
        this.type = gameType;
    }

    @Override
    public String toString() {
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
    }

}
