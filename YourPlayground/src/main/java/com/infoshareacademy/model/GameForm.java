package com.infoshareacademy.model;

import com.infoshareacademy.service.FormServiceImpl;
import com.infoshareacademy.utils.GameType;

import java.util.List;

public class GameForm {

    private String name;
    private GameType type;
    private int maxNumberOfPlayers;
    private List<Player> players;
    private Location gameLocation;
    private DateOfGame dateOfGame;
    private Player gameOwner;

    public GameForm() {
        this.gameLocation = new Location();
        this.dateOfGame = new DateOfGame();
        this.gameOwner = new Player();
    }


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

    public int getMaxNumberOfPlayers() {
        return maxNumberOfPlayers;
    }

    public void setMaxNumberOfPlayers(int maxNumberOfPlayers) {
        this.maxNumberOfPlayers = maxNumberOfPlayers;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Location getGameLocation() {
        return gameLocation;
    }

    public void setGameLocation(Location gameLocation) {
        this.gameLocation = gameLocation;
    }

    public DateOfGame getDateOfGame() {
        return dateOfGame;
    }

    public void setDateOfGame(DateOfGame dateOfGame) {
        this.dateOfGame = dateOfGame;
    }

    public Player getGameOwner() {
        return gameOwner;
    }

    public void setGameOwner(Player gameOwner) {
        this.gameOwner = gameOwner;
    }
}
