package com.infoshareacademy.service;

import com.infoshareacademy.model.Game;
import com.infoshareacademy.model.Location;

public class GameServiceImpl implements GameService {

    @Override
    public Game createGame(String name, String type, int numberOfPlayers, Location gameLocation) {
        return new Game(name, type, numberOfPlayers, gameLocation);
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
}
