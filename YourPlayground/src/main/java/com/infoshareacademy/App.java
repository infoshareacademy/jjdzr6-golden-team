package com.infoshareacademy;

import com.infoshareacademy.model.Game;
import com.infoshareacademy.model.Location;
import com.infoshareacademy.model.Player;
import com.infoshareacademy.utils.GameType;

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
                .addGameLocation(new Location(1.23,3.567,"Warsaw"))
                .build();

        System.out.println(game);

        game.addPlayerToListOfPlayers(new Player("Michael","michael@gmail.com"));
        game.addPlayerToListOfPlayers(new Player("John","john@gmail.com"));
        game.addPlayerToListOfPlayers(new Player("Jack","jack@gmail.com"));
        game.addPlayerToListOfPlayers(new Player("Clay","clay@gmail.com"));
        game.addPlayerToListOfPlayers(new Player("Sue","sue@gmail.com"));
        game.addPlayerToListOfPlayers(new Player("Anne","anne@gmail.com"));
        game.addPlayerToListOfPlayers(new Player("Patrick","patrick@gmail.com"));
        game.addPlayerToListOfPlayers(new Player("Phillip","phill@gmail.com"));
        game.addPlayerToListOfPlayers(new Player("Max","madmax@gmail.com"));
        game.addPlayerToListOfPlayers(new Player("Justin","justine@gmail.com"));

        System.out.println(game);
    }
}
