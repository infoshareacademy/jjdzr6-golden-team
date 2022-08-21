package com.infoshareacademy.service;

import com.infoshareacademy.entity.Game;
import com.infoshareacademy.entity.Player;
import java.io.IOException;
import java.util.List;


public interface GameService {
    //region Methods
    Game prepareSearchGame();

    List<Game> printFoundGames(Game searchedGame) throws IOException;

    void deleteGame();

    void addPlayerToGame(Player player, Game game);
    //endregion
}
