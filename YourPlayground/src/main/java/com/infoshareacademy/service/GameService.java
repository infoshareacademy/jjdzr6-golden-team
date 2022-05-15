package com.infoshareacademy.service;

import com.infoshareacademy.model.Game;
import com.infoshareacademy.model.Location;

public class GameService {
    //region Methods
    public Game createGame(String name, String type, int numberOfPlayers, Location gameLocation) {
        return new Game(name, type, numberOfPlayers, gameLocation);
    }
    //endregion
}
