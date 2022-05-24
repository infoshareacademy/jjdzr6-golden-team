package com.infoshareacademy.model;

import com.infoshareacademy.service.GameServiceImpl;

public class Game extends GameServiceImpl {
    //region Fields
    private String name;
    private String type;
    private int numberOfPlayers;
    private Location gameLocation;
    //endregion

    //region Constructor
    public Game(String name, String type, int numberOfPlayers, Location gameLocation) {
        this.name = name;
        this.type = type;
        this.numberOfPlayers = numberOfPlayers;
        this.gameLocation = gameLocation;
    }
    //endregion

    //region Getters&Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
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
                ", type='" + type + '\'' +
                ", numberOfPlayers=" + numberOfPlayers +
                ", gameLocation=" + gameLocation +
                '}';
    }
}
