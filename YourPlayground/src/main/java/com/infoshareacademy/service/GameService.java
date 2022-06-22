package com.infoshareacademy.service;

import com.infoshareacademy.model.Game;
import com.infoshareacademy.model.Player;

import java.io.IOException;

public interface GameService {
    //region Methods
    Game prepareSearchGame();

    void printFoundGames(Game searchedGame) throws IOException;

    void deleteGame();

    void joinGame();

    void addPlayerToGame(Player player, Game game);
    //endregion
}
