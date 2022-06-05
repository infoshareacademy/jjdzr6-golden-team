package com.infoshareacademy.service;

import com.infoshareacademy.model.Game;
import com.infoshareacademy.model.Player;
import com.infoshareacademy.utils.GameType;

public class GameServiceImpl implements GameService {

    @Override
    public Game createGame() {
        Game game = new Game();
        return game;
    }

    @Override
    public void searchGame() {
        //TODO
    }

    @Override
    public void deleteGame() {
        //TODO
    }

    @Override
    public void joinGame() {
        //TODO
    }

    @Override
    public void addPlayerToGame(Player player) {

        if (createGame().getPlayers().size() < createGame().getMaxNumberOfPlayers()) {
            createGame().getPlayers().add(player);
        } else {
            System.out.println("Game is full.");
        }
    }
}
