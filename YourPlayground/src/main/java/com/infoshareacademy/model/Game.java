package com.infoshareacademy.model;

import com.google.gson.GsonBuilder;
import com.infoshareacademy.service.GameServiceImpl;
import com.infoshareacademy.utils.GameType;

import java.util.List;

public class Game extends GameServiceImpl {
    // Fields
    private String name;
    private GameType type;
    private int maxNumberOfPlayers;
    private List<Player> players;
    private Location gameLocation;
    private GameDate dateOfGame;
    private Player gameOwner;

    // Constructor
    public Game() {
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

    public GameDate getDateOfGame() {
        return dateOfGame;
    }

    public Player getGameOwner() {

        return gameOwner;
    }

    public List<Player> getPlayers() {
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

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void setGameLocation(Location gameLocation) {
        this.gameLocation = gameLocation;
    }

    public void setDateOfGame(GameDate dateOfGame) {
        this.dateOfGame = dateOfGame;
    }

    public void setGameOwner(Player gameOwner) {
        this.gameOwner = gameOwner;
    }
}
