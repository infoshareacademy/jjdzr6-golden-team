package com.infoshareacademy.service;

import com.infoshareacademy.builders.GameBuilder;
import com.infoshareacademy.model.Game;

public class GameServiceImpl implements GameService {

    @Override
    public Game createGame(GameBuilder gameBuilder) {
        return gameBuilder.buildGame();
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
