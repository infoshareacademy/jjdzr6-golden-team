package com.infoshareacademy.service;

import com.infoshareacademy.model.Game;
import com.infoshareacademy.model.Player;

public interface GameService {
    //region Methods
    public Game createGame();

    public void searchGame();

    public void deleteGame();

    public void joinGame();

    public void addPlayerToGame(Player player);
    //endregion
}
