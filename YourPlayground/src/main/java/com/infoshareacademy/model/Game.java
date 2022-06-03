package com.infoshareacademy.model;

import com.infoshareacademy.service.GameServiceImpl;
import com.infoshareacademy.utils.GameType;

import java.util.List;

public class Game extends GameServiceImpl {
    // Fields
    private final String name;
    private final GameType type;
    private final int maxNumberOfPlayers;
    private final List<Player> players;
    private final Location gameLocation;
    private final DateOfGame dateOfGame;

    // Constructor
    private Game(Builder builder) {
        this.name = builder.name;
        this.type = builder.type;
        this.maxNumberOfPlayers = builder.maxNumberOfPlayers;
        this.players = builder.players;
        this.gameLocation = builder.gameLocation;
        this.dateOfGame = builder.dateOfGame;
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

    public List<Player> getPlayers() {
        return players;
    }

    public Location getGameLocation() {
        return gameLocation;
    }

    public DateOfGame getDateOfGame() {
        return dateOfGame;
    }

    //endregion

    public static final class Builder {

        private String name;
        private GameType type;
        private int maxNumberOfPlayers;
        private List<Player> players;
        private Location gameLocation;
        private DateOfGame dateOfGame;

        // Builder Factory
        public static Builder builder() {
            return new Builder();
        }

        // Builder methods
        public Builder addName(String name) {
            this.name = name;
            return this;
        }

        public Builder addGameType(GameType type) {
            this.type = type;
            return this;
        }

        public Builder addMaxNumberOfPlayers(int maxNumberOfPlayers) {
            this.maxNumberOfPlayers = maxNumberOfPlayers;
            return this;
        }

        public Builder addListOfPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder addGameLocation(Location gameLocation) {
            this.gameLocation = gameLocation;
            return this;
        }

        public Builder addDateOfGame(DateOfGame dateOfGame) {
            this.dateOfGame = dateOfGame;
            return this;
        }

        public Game build() {
            return new Game(this);
        }
    }

}
