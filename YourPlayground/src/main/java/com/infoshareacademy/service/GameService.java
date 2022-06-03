package com.infoshareacademy.service;

import com.infoshareacademy.model.Game;

public interface GameService {
    //region Methods
    public Game createGame();

    public void searchGame();

    public void deleteGame();

    public void joinGame();
    //endregion
}
