package com.infoshareacademy.model;

import com.infoshareacademy.service.GameServiceImpl;
import com.infoshareacademy.utils.GameType;

import java.util.ArrayList;
import java.util.List;

public class Game extends GameServiceImpl {
    // Fields
    private final String name;
    private final GameType type;
    private final int maxNumberOfPlayers;
    private final List<Player> players;
    private final Location gameLocation;
    private final DateOfGame dateOfGame;
    private final Player gameInitiator;

    // Constructor
    private Game(Builder builder) {
        this.name = builder.name;
        this.type = builder.type;
        this.maxNumberOfPlayers = builder.maxNumberOfPlayers;
        this.players = builder.players;
        this.gameLocation = builder.gameLocation;
        this.dateOfGame = builder.dateOfGame;
        this.gameInitiator = builder.gameInitiator;
    }

    /**
     * Static factory method that creates builder.
     * @return new game builder.
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Adds a player to the game's list of players.
     * @param player that is added to the list.
     */
    public void addPlayerToListOfPlayers(Player player) {
        if (this.players.size() < this.maxNumberOfPlayers) {
            this.players.add(player);
        } else {
            System.out.println("Number of players is full.");
        }
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

    public DateOfGame getDateOfGame() {
        return dateOfGame;
    }

    public Player getGameInitiator() {
        return gameInitiator;
    }

    //endregion

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", maxNumberOfPlayers=" + maxNumberOfPlayers +
                ", players=" + players +
                ", gameLocation=" + gameLocation +
                ", dateOfGame=" + dateOfGame +
                ", gameInitiator=" + gameInitiator +
                '}';
    }

    public static final class Builder {

        private String name;
        private GameType type;
        private int maxNumberOfPlayers;
        private final List<Player> players;
        private Location gameLocation;
        private DateOfGame dateOfGame;
        private Player gameInitiator;

        // Constructor
        private Builder() {
            this.players = new ArrayList<>();
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

        public Builder addGameLocation(Location gameLocation) {
            this.gameLocation = gameLocation;
            return this;
        }

        public Builder addDateOfGame(DateOfGame dateOfGame) {
            this.dateOfGame = dateOfGame;
            return this;
        }

        public Builder addGameInitiator(Player gameInitiator) {
            this.gameInitiator = gameInitiator;
            return this;
        }

        public Game build() {
            Game game = new Game(this);
            game.addPlayerToListOfPlayers(gameInitiator);
            return game;
        }
    }
}
