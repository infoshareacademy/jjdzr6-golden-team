package com.infoshareacademy.service;

import com.infoshareacademy.builders.GameBuilder;
import com.infoshareacademy.model.Game;

public interface GameService {
    //region Methods
    public Game createGame(GameBuilder gameBuilder);

    public void searchGame();

    public void deleteGame();

    public void joinGame();
    //endregion
}
