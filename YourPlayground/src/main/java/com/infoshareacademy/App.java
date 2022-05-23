package com.infoshareacademy;

import com.infoshareacademy.gui.Menu;
import com.infoshareacademy.model.Game;
import com.infoshareacademy.model.Location;
import com.infoshareacademy.model.SportForm;
import com.infoshareacademy.service.FormServiceImpl;
import com.infoshareacademy.utils.GameType;

import java.io.IOException;

/**
 * YourPlayground App allows you to easily find games you love to play in your city.
 */
public class App {
    public static void main(String[] args) throws IOException {
        // Menu test
        Game game = new Game("pingpong", GameType.SPORT, 12, new Location(12.2, 123.3));
        FormServiceImpl form = new SportForm(game);

        form.saveToJson(game);

        form.printGamesFromJson();
    }
}
