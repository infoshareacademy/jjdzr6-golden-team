package com.infoshareacademy;

import com.infoshareacademy.gui.Menu;
import com.infoshareacademy.model.Game;
import com.infoshareacademy.model.GameForm;
import com.infoshareacademy.model.Location;
import com.infoshareacademy.model.Player;
import com.infoshareacademy.service.FormServiceImpl;
import com.infoshareacademy.utils.GameType;

import java.io.IOException;

/**
 * YourPlayground App allows you to easily find games you love to play in your city.
 */
public class App {
    public static void main(String[] args) throws IOException {

        Game game = new Game();
        game.setName("bilard");
        game.setType(GameType.BOARD);
        FormServiceImpl form = new GameForm(game);

        form.saveToJsonFile(game);

        form.printGamesFromJson();

    }
}
