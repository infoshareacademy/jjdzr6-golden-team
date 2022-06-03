package com.infoshareacademy.model;

import com.infoshareacademy.service.GameServiceImpl;
import com.infoshareacademy.utils.GameType;

import java.util.List;

public class Game extends GameServiceImpl {
    //region Fields
    private String name;
    private GameType type;
    private List<Player> players;
    private int numberOfPlayers;
    private Location gameLocation;
    private DateOfGame dateOfGame;
    private City city;

    //endregion

    //region Constructor
    public Game(String name, GameType type) {
        this.name = name;
        this.type = type;
    }

    public Game() {}

    //endregion

    //region Getters

    public String getName() {
        return name;
    }

    public GameType getType() {
        return type;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public Location getGameLocation() {
        return gameLocation;
    }

    public DateOfGame getDateOfGame() {
        return dateOfGame;
    }

    public City getCity() {
        return city;
    }

    //endregion


    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", players=" + players +
                ", numberOfPlayers=" + numberOfPlayers +
                ", gameLocation=" + gameLocation +
                ", dateOfGame=" + dateOfGame +
                ", city=" + city +
                '}';
    }
}
