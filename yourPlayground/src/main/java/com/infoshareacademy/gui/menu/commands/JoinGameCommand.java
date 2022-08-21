package com.infoshareacademy.gui.menu.commands;

import com.infoshareacademy.gui.menu.ConsoleCommand;
import com.infoshareacademy.gui.menu.ContinueHandler;
import com.infoshareacademy.entity.Game;
import com.infoshareacademy.entity.Player;
import com.infoshareacademy.service.FormServiceImpl;
import com.infoshareacademy.service.GameServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import static java.util.Objects.requireNonNull;

@Component
@Order(1)
class JoinGameCommand implements ConsoleCommand {

    @Autowired
    GameServiceImpl gameService;

    @Autowired
    ContinueHandler continueHandler;

    private final String input;
    private final ApplicationContext context;

    JoinGameCommand(ApplicationContext context) {
        this.input = requireNonNull("1").toLowerCase(Locale.ROOT);
        this.context = context;
    }

    @Override
    public boolean canHandle(String input) {
        return this.input.equals(input.toLowerCase(Locale.ROOT));
    }

    @Override
    public void handle(String input) throws IOException {

        if (continueHandler.continueHandler()) {
            int userInput = -1;

            Player player = new Player();
            Scanner scanner = new Scanner(System.in);
            FormServiceImpl formService = new FormServiceImpl();
            List<Game> listOfGames = new ArrayList<>();

            System.out.println("Type your name: ");
            player.setUsername(scanner.nextLine());

            System.out.println("Type your e-mail: ");
            player.setMail(scanner.nextLine());

            listOfGames = gameService.printFoundGames(gameService.prepareSearchGame());


            if (!listOfGames.isEmpty()) {
                System.out.println("Which game would you like to join?\n\r");
                userInput = scanner.nextInt() - 1;

                gameService.addPlayerToGame(player, listOfGames.get(userInput));

                try {
                    formService.editJsonFile(userInput, listOfGames.get(userInput));
                } catch (IOException e) {
                    System.out.println("File not found.");
                }
            } else System.out.println("Nie ma takiej gry.");
        }
    }

    @Override
    public String introduce() {
        return input + ". Join game";
    }
}
