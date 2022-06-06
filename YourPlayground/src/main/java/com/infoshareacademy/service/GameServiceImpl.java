package com.infoshareacademy.service;

import com.infoshareacademy.model.Game;
import com.infoshareacademy.model.GameForm;
import com.infoshareacademy.model.Player;
import com.infoshareacademy.utils.GameType;

public class GameServiceImpl implements GameService {

    @Override
    public Game createGame(GameForm gameForm) {
        return new Game();
    }

    @Override
    public void searchGame() {
        //TODO
    }

    @Override
    public void printGames() {
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
    public void addPlayerToGame(Player player, Game game) {

        if (game.getPlayers().size() < game.getMaxNumberOfPlayers()) {
            game.getPlayers().add(player);
        } else {
            System.out.println("Game is full.");
        }
    }
}
