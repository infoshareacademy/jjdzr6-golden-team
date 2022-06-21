package com.infoshareacademy;

import com.infoshareacademy.service.FormServiceImpl;
import com.infoshareacademy.service.GameServiceImpl;

import java.io.IOException;
import java.text.ParseException;

/**
 * YourPlayground App allows you to easily find games you love to play in your city.
 */
public class App {
    public static void main(String[] args) throws IOException, ParseException {

        FormServiceImpl formService = new FormServiceImpl();
        GameServiceImpl gameService = new GameServiceImpl();

        formService.closeForm(formService.createForm());

        gameService.printFoundGames(gameService.prepareSearchGame());

        gameService.joinGame();

    }
}