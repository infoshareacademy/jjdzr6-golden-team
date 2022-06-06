package com.infoshareacademy;

import com.google.gson.Gson;
import com.infoshareacademy.gui.Menu;
import com.infoshareacademy.model.Game;
import com.infoshareacademy.model.GameForm;
import com.infoshareacademy.model.Location;
import com.infoshareacademy.model.Player;
import com.infoshareacademy.service.FormServiceImpl;
import com.infoshareacademy.service.GameServiceImpl;
import com.infoshareacademy.utils.GameType;

import java.io.IOException;
import java.text.ParseException;

/**
 * YourPlayground App allows you to easily find games you love to play in your city.
 */
public class App {
    public static void main(String[] args) throws IOException, ParseException {

        GameForm gameForm = new GameForm();
        FormServiceImpl formService = new FormServiceImpl();
        GameServiceImpl gameService = new GameServiceImpl();

        gameService.printFoundGames(gameService.prepareSearchGame());

        /*Game game = formService.printForm();

        formService.saveToJsonFile(game);

        formService.printGamesFromJson();*/


    }
}
