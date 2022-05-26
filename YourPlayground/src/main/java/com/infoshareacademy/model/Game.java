package com.infoshareacademy.model;

import com.infoshareacademy.service.GameServiceImpl;
import com.infoshareacademy.utils.GameType;

public class Game extends GameServiceImpl {
    //region Fields
    private String name;
    private GameType type;
    private int numberOfPlayers;
    private Location gameLocation;

    //endregion

    //region Constructor
    public Game(String name, GameType type, int numberOfPlayers, Location gameLocation) {
        this.name = name;
        this.type = type;
        this.numberOfPlayers = numberOfPlayers;
        this.gameLocation = gameLocation;
    }

    public Game(GameType type) {
        this.type = type;
    }

    //endregion

    //region Getters&Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GameType getType() {
        return type;
    }

    public void setType(GameType type) {
        this.type = type;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public Location getGameLocation() {
        return gameLocation;
    }

    public void setGameLocation(Location gameLocation) {
        this.gameLocation = gameLocation;
    }
    //endregion

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", type='" + type.toString() + '\'' +
                ", numberOfPlayers=" + numberOfPlayers +
                ", gameLocation=" + gameLocation +
                '}';
    }
}
