package com.infoshareacademy;

import com.infoshareacademy.gui.Menu;
import com.infoshareacademy.model.Game;
import com.infoshareacademy.model.GameForm;
import com.infoshareacademy.model.Location;
import com.infoshareacademy.model.Player;
import com.infoshareacademy.service.FormServiceImpl;
import com.infoshareacademy.utils.GameType;

import java.io.IOException;
import java.text.ParseException;

/**
 * YourPlayground App allows you to easily find games you love to play in your city.
 */
public class App {
    public static void main(String[] args) throws IOException, ParseException {

        GameForm gameForm = new GameForm();

        Game game = gameForm.printForm();

        gameForm.saveToJsonFile(game);

        gameForm.printGamesFromJson();

    }
}
