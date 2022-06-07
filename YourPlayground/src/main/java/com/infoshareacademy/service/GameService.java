package com.infoshareacademy.service;

import com.infoshareacademy.model.Game;
import com.infoshareacademy.model.Player;

import java.io.IOException;

public interface GameService {
    //region Methods
    public Game prepareSearchGame();

    public void printFoundGames(Game searchedGame) throws IOException;

    public void deleteGame();

    public void joinGame();

    public void addPlayerToGame(Player player, Game game);
    //endregion
}
