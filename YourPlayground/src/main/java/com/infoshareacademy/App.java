package com.infoshareacademy;

import com.infoshareacademy.model.Game;
import com.infoshareacademy.model.Location;
import com.infoshareacademy.model.Player;
import com.infoshareacademy.utils.GameType;

import java.util.ArrayList;

/**
 * YourPlayground App allows you to easily find games you love to play in your city.
 */
public class App {
    public static void main(String[] args) {

        Game game = Game.builder()
                .addGameType(GameType.SPORTS)
                .addName("Basketball")
                .addGameInitiator(new Player("Jake", "jake@gmail.com"))
                .addMaxNumberOfPlayers(10)
                .addListOfPlayers(new ArrayList<>())
                .addGameLocation(new Location(1.23,3.567,"Warsaw"))
                .build();

        System.out.println(game);

        Player player1 = new Player("Michael","michael@gmail.com");

        game.getPlayers().add(player1);

        System.out.println(game);
    }
}
