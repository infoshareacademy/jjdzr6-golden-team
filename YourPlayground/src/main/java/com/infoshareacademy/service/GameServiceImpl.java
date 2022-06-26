package com.infoshareacademy.service;

import com.infoshareacademy.model.Game;
import com.infoshareacademy.model.Location;
import com.infoshareacademy.model.Player;

import java.io.IOException;
import java.util.*;

import static javax.swing.text.html.HTML.Tag.S;

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
    public List<Game> printFoundGames(Game searchedGame) throws IOException {
        FormServiceImpl formService = new FormServiceImpl();

        List<Game> foundGames = new ArrayList<>();
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
                    foundGames.add(game);
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
                    foundGames.add(game);
                    count++;
                    System.out.printf("%d. %s, Ilość graczy: %d/%d, Miasto: %s%n",
                            count, game.getName(), game.getPlayers().size(), game.getMaxNumberOfPlayers(),
                            game.getGameLocation().getTown());
                }
            }
            System.out.println("To już wszystkie pasujące gry.");


        } else System.out.println("Sth went wrong...");

        return foundGames;
    }

    @Override
    public void deleteGame() {
        //TODO nie wiem czy jest sens to robić
    }

    @Override
    public void joinGame() throws IOException {
        int userInput = -1;
        Player player = new Player();
        Scanner scanner = new Scanner(System.in);
        FormServiceImpl formService = new FormServiceImpl();
        List<Game> listOfGames = new ArrayList<>();

        System.out.println("Type your name: ");
        player.setName(scanner.nextLine());

        System.out.println("Type your e-mail: ");
        player.setMail(scanner.nextLine());

        listOfGames= printFoundGames(prepareSearchGame());

        System.out.println("Which game would you like to join?\n\r");

        userInput = scanner.nextInt() - 1;

        addPlayerToGame(player, listOfGames.get(userInput));

        try {
            formService.editJsonFile(userInput, listOfGames.get(userInput));
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

    @Override
    public void addPlayerToGame(Player player, Game game) {

        if (game.getPlayers() == null) {
            Set<Player> playerList = new HashSet<>();
            playerList.add(player);
            game.setPlayers(playerList);
        } else if (game.getPlayers().size() < game.getMaxNumberOfPlayers()) {
            game.getPlayers().add(player);
            System.out.println("You are added to the game.");
        } else {
            System.out.println("Game is full.");
        }
    }
}
