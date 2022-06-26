package com.infoshareacademy.model;

import com.google.gson.GsonBuilder;
import com.infoshareacademy.service.GameServiceImpl;
import com.infoshareacademy.utils.GameType;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

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

    @Override
    public String toString() {
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
    }

    //region Getters

    public String getName() {
        return name;
    }

    public GameType getType() {
        return type;
    }

    public int getMaxNumberOfPlayers() {
        return maxNumberOfPlayers;
    }

    public Location getGameLocation() {
        return gameLocation;
    }

    public LocalDateTime getDateOfGame() {
        return dateOfGame;
    }

    public Player getGameOwner() {

        return gameOwner;
    }

    public Set<Player> getPlayers() {
        return players;
    }
    //endregion

    public void setName(String name) {
        this.name = name;
    }

    public void setType(GameType type) {
        this.type = type;
    }

    public void setMaxNumberOfPlayers(int maxNumberOfPlayers) {
        this.maxNumberOfPlayers = maxNumberOfPlayers;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    public void setGameLocation(Location gameLocation) {
        this.gameLocation = gameLocation;
    }

    public void setDateOfGame(LocalDateTime dateOfGame) {
        this.dateOfGame = dateOfGame;
    }

    public void setGameOwner(Player gameOwner) {
        this.gameOwner = gameOwner;
    }
}
