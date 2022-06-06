package com.infoshareacademy.service;

import com.infoshareacademy.model.Game;
import com.infoshareacademy.model.GameForm;
import com.infoshareacademy.model.Player;
import com.infoshareacademy.utils.GameType;

import java.util.ArrayList;
import java.util.List;

public class GameServiceImpl implements GameService {

    @Override
    public Game createGame(GameForm gameForm, Game game) {

        game.setName(gameForm.getName());
        game.setType(gameForm.getType());
        game.setMaxNumberOfPlayers(gameForm.getMaxNumberOfPlayers());
        game.setGameLocation(gameForm.getGameLocation());
        game.setDateOfGame(gameForm.getDateOfGame());
        game.setGameOwner(gameForm.getGameOwner());
        game.setGameForm(gameForm);

        return game;
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

        if (game.getPlayers()==null) {
            List<Player> playerList = new ArrayList<>();
            playerList.add(player);
            game.setPlayers(playerList);
        } else if (game.getPlayers().size() < game.getMaxNumberOfPlayers()) {
            game.getPlayers().add(player);
        } else {
            System.out.println("Game is full.");
        }
    }
}
