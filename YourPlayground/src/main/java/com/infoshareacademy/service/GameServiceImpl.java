package com.infoshareacademy.service;

import com.infoshareacademy.model.Game;
import com.infoshareacademy.model.GameForm;
import com.infoshareacademy.model.Player;
import com.infoshareacademy.model.SearchParams;
import com.infoshareacademy.utils.GameType;

import java.awt.desktop.SystemEventListener;
import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameServiceImpl implements GameService {

    @Override
    public Game createGame(GameForm gameForm, Game game) {

        game.setName(gameForm.getName());
        game.setType(gameForm.getType());
        game.setMaxNumberOfPlayers(gameForm.getMaxNumberOfPlayers());
        game.setGameLocation(gameForm.getGameLocation());
        game.setDateOfGame(gameForm.getDateOfGame());
        game.setGameOwner(gameForm.getGameOwner());
        game.setGameForm(gameForm);

        return game;
    }

    @Override
    public SearchParams prepareSearchGame() {
        SearchParams searchParams = new SearchParams();

        System.out.println("Jakiej gry szukasz?");
        System.out.println("1. Sportowa\n2. Planszowa");

        Scanner scanner = new Scanner(System.in);
        int type = scanner.nextInt();
        if (type == 1) {
            searchParams.setGameType(GameType.SPORTS);
        } else if (type == 2) {
            searchParams.setGameType(GameType.BOARD);
        } else {
            System.out.println("ty baranie");
        }

        scanner = new Scanner(System.in);
        System.out.println("Podaj nazwę gry: ");
        searchParams.setGameName(scanner.nextLine());

        scanner = new Scanner(System.in);
        System.out.println("Podaj miasto gry: ");
        searchParams.setMiasto(scanner.nextLine());

        return searchParams;
    }

    @Override
    public void printFoundGames(SearchParams searchParams) throws IOException {
        FormServiceImpl formService = new FormServiceImpl();

        Game[] games = formService.fromJson();

        System.out.println("Czy chcesz wyszukać grę ze wszystkimi parametrami? (Y/N)");
        Scanner scanner = new Scanner(System.in);
        char choice = scanner.next().charAt(0);

        if (choice == 'Y' || choice == 'y') {
            System.out.println("Gry pasujące idealnie: ");
            int count = 0;
            for (Game game : games) {
                if (game.getName() == searchParams.getGameName() && game.getGameLocation().getTown() == searchParams.getMiasto()
                        && game.getType() == searchParams.getGameType()) {
                    count++;
                    System.out.printf("%d. %s, Ilość graczy: %d/%d, Miasto: %s\n",
                            count, game.getName(), game.getPlayers().size(), game.getMaxNumberOfPlayers(),
                            game.getGameLocation().getTown());
                }
            }
            System.out.println("To już wszystkie pasujące gry.");

        } else if (choice == 'N' || choice == 'n') {
            System.out.println("Gry pasujące co najmniej jednym parametrem: ");
            int count = 0;
            for (Game game : games) {
                if (game.getName() == searchParams.getGameName() || game.getGameLocation().getTown() == searchParams.getMiasto()
                        || game.getType() == searchParams.getGameType()) {
                    count++;
                    System.out.printf("%d. %s, Ilość graczy: %d/%d, Miasto: %s\n",
                            count, game.getName(), game.getPlayers().size(), game.getMaxNumberOfPlayers(),
                            game.getGameLocation().getTown());
                }
            }
            System.out.println("To już wszystkie pasujące gry.");
        } else System.out.println("ty baranie");
    }

    @Override
    public void deleteGame() {
        //TODO
    }

    @Override
    public void joinGame() {
        //TODO
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
