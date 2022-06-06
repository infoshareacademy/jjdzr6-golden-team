package com.infoshareacademy.service;

import com.infoshareacademy.model.Game;
import com.infoshareacademy.model.GameForm;
import com.infoshareacademy.model.Player;
import com.infoshareacademy.model.SearchParams;

import java.io.IOException;

public interface GameService {
    //region Methods
    public Game createGame(GameForm gameForm, Game game);

    public SearchParams prepareSearchGame();

    public void printFoundGames(SearchParams searchParams) throws IOException;

    public void deleteGame();

    public void joinGame();

    public void addPlayerToGame(Player player, Game game);
    //endregion
}
