package com.infoshareacademy.service;

import com.infoshareacademy.model.Game;
import com.infoshareacademy.model.Location;
import com.infoshareacademy.model.Player;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GameServiceImpl implements GameService, GameTypeService {

    @Override
    public Game prepareSearchGame() {
        Game searchedGame = new Game();

        System.out.println("Jakiej gry szukasz?");
        System.out.println("1. Sportowa\n2. Planszowa");

        whichGameType(searchedGame);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj nazwę gry: ");
        searchedGame.setName(scanner.nextLine());

        scanner = new Scanner(System.in);
        System.out.println("Podaj miasto gry: ");
        searchedGame.setGameLocation(new Location());
        searchedGame.getGameLocation().setTown(scanner.nextLine());

        return searchedGame;
    }

    @Override
    public void printFoundGames(Game searchedGame) throws IOException {
        FormServiceImpl formService = new FormServiceImpl();

        Game[] games = formService.fromJson();

        System.out.println("Czy chcesz wyszukać grę ze wszystkimi parametrami? (Y/N)");
        Scanner scanner = new Scanner(System.in);
        char choice = scanner.next().charAt(0);

        if (choice == 'Y' || choice == 'y') {
            System.out.println("Gry pasujące idealnie: ");
            int count = 0;
            for (Game game : games) {
                if (game.getName().equals(searchedGame.getName()) && game.getGameLocation().getTown().equals(searchedGame.getGameLocation().getTown())
                        && game.getType() == searchedGame.getType()) {
                    count++;
                    System.out.printf("%d. %s, Ilość graczy: %d/%d, Miasto: %s%n",
                            count, game.getName(), game.getPlayers().size(), game.getMaxNumberOfPlayers(),
                            game.getGameLocation().getTown());
                }
            }
            System.out.println("To już wszystkie pasujące gry.");

        } else if (choice == 'N' || choice == 'n') {
            System.out.println("Gry pasujące co najmniej jednym parametrem: ");
            int count = 0;
            for (Game game : games) {
                if (game.getName().equals(searchedGame.getName()) || game.getGameLocation().getTown().equals(searchedGame.getGameLocation().getTown())
                        || game.getType() == searchedGame.getType()) {
                    count++;
                    System.out.printf("%d. %s, Ilość graczy: %d/%d, Miasto: %s%n",
                            count, game.getName(), game.getPlayers().size(), game.getMaxNumberOfPlayers(),
                            game.getGameLocation().getTown());
                }
            }
            System.out.println("To już wszystkie pasujące gry.");
        } else System.out.println("ty baranie");
    }

    @Override
    public void deleteGame() {
        //TODO nie wiem czy jest sens to robić
    }

    @Override
    public void joinGame() {
        int userInput = -1;
        String userName;
        String userMail;
        Scanner scanner = new Scanner(System.in);
        FormServiceImpl formService = new FormServiceImpl();
        List<Game> listOfGames = new ArrayList<>();

        System.out.println("Type your name: ");
        userName = scanner.nextLine();

        System.out.println("Type your e-mail: ");
        userMail = scanner.nextLine();

        System.out.println("Which game would you like to join?\n\r");

        try {
            formService.printGamesFromJson();
            listOfGames = Arrays.asList(formService.fromJson());
        } catch (IOException e) {
            System.out.println("File not found");
        }

        userInput = scanner.nextInt() - 1;

        addPlayerToGame(new Player(userName, userMail), listOfGames.get(userInput));

        try {
            formService.editJsonFile(userInput, listOfGames.get(userInput));
            System.out.println("You are added to the game!");
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

    @Override
    public void addPlayerToGame(Player player, Game game) {

        if (game.getPlayers() == null) {
            List<Player> playerList = new ArrayList<>();
            playerList.add(player);
            game.setPlayers(playerList);
        } else if (game.getPlayers().size() < game.getMaxNumberOfPlayers()) {
            game.getPlayers().add(player);
        } else {
            System.out.println("Game is full.");
        }
    }
}
