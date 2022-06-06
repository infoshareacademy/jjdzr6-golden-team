package com.infoshareacademy.service;

import com.infoshareacademy.model.Game;
import com.infoshareacademy.model.GameForm;
import com.infoshareacademy.model.Player;

public interface GameService {
    //region Methods
    public Game createGame(GameForm gameForm, Game game);

    public void searchGame();

    public void printGames();

    public void deleteGame();

    public void joinGame();

    public void addPlayerToGame(Player player, Game game);
    //endregion
}
