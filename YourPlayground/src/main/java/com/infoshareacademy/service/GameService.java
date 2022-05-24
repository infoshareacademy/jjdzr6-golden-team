package com.infoshareacademy.service;

import com.infoshareacademy.model.Game;
import com.infoshareacademy.model.Location;
import com.infoshareacademy.utils.GameType;

public interface GameService {
    //region Methods
    public Game createGame(String name, GameType type, int numberOfPlayers, Location gameLocation);

    public void searchGame();

    public void deleteGame();

    public void joinGame();
    //endregion
}
