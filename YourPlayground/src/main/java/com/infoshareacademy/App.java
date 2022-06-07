package com.infoshareacademy;

import com.infoshareacademy.service.GameServiceImpl;

import java.io.IOException;
import java.text.ParseException;

/**
 * YourPlayground App allows you to easily find games you love to play in your city.
 */
public class App {
    public static void main(String[] args) throws IOException, ParseException {
/*
        GameForm gameForm = new GameForm();
        FormServiceImpl formService = new FormServiceImpl();
        GameServiceImpl gameService = new GameServiceImpl();

        gameService.printFoundGames(gameService.prepareSearchGame());
*/
        GameServiceImpl gameService = new GameServiceImpl();
        gameService.joinGame();

    }
}