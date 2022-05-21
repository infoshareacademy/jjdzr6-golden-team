package com.infoshareacademy.service;

import com.infoshareacademy.model.Game;
import com.infoshareacademy.model.Location;
public interface GameService {
    //region Methods
    public Game createGame(String name, String type, int numberOfPlayers, Location gameLocation);

    public void searchGame();

    public void deleteGame();

    public void joinGame();
    //endregion
}
