package com.infoshareacademy.service;

import com.infoshareacademy.model.Game;
import com.infoshareacademy.model.Player;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;


public interface GameService {
    //region Methods
    Game prepareSearchGame();

    List<Game> printFoundGames(Game searchedGame) throws IOException;

    void deleteGame();

    void joinGame() throws IOException;

    void addPlayerToGame(Player player, Game game);
    //endregion
}
