package com.infoshareacademy.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.infoshareacademy.model.*;
import com.infoshareacademy.utils.GameType;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class FormServiceImpl implements FormService, JsonService {

    public static final String RESOURCE_PATH ="YourPlayground/src/main/resources";



    @Override
    public Game printForm() throws ParseException {
        Game game = new Game();
        game.setGameForm(new GameForm());

        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj swoje imię: ");
        game.getGameForm().setGameOwner(new Player());
        game.getGameForm().getGameOwner().setName(scanner.nextLine());

        System.out.println("Podaj swojego emaila: ");
        game.getGameForm().getGameOwner().setMail(scanner.nextLine());
        game.addPlayerToGame(game.getGameForm().getGameOwner(), game);

        System.out.println(game.getGameForm().getGameOwner());
        System.out.println(game.getPlayers());
        System.out.println("Wybierz rodzaj gry: ");
        System.out.println("1. Sport");
        System.out.println("2. Board");

        int type = scanner.nextInt();

        if(type == 1)  {
            game.getGameForm().setType(GameType.SPORTS);
        }
        else if (type == 2) {
            game.getGameForm().setType(GameType.BOARD);
        }
        else System.out.println("ty baranie");

        scanner = new Scanner(System.in);

        System.out.println("Podaj nazwę gry: ");
        game.getGameForm().setName(scanner.nextLine());

        System.out.println("Podaj liczbę graczy: ");
        game.getGameForm().setMaxNumberOfPlayers(scanner.nextInt());

        scanner = new Scanner(System.in);

        System.out.println("Podaj miasto: ");
        game.getGameForm().getGameLocation().setTown(scanner.nextLine());

        scanner = new Scanner(System.in);

        System.out.println("Podaj datę gry (dd-mm-yyyy): ");
        game.getGameForm().getDateOfGame().setGameDate(scanner.nextLine());

        game.createGame(game.getGameForm(), game);

        return game;
    }

    @Override
    public void closeForm() {
        //TODO
    }

    @Override
    public JSONArray toJsonArray() throws IOException {

        JSONArray jsonArray = new JSONArray(fromJson());
        return jsonArray;
    }

    @Override
    public Game[] fromJson() throws IOException {

        Gson gson = new GsonBuilder().create();

        Path filePath = Paths.get(RESOURCE_PATH.toString(), "games.json");

        String file = Files.readString(filePath);

        Game[] games = gson.fromJson(file, Game[].class);

        return games;
    }

    @Override
    public void saveToJsonFile(Game game) throws IOException {

        Gson gson = new GsonBuilder().create();

        Path filePath = Paths.get(RESOURCE_PATH.toString(), "games.json");

        Writer writer = Files.newBufferedWriter(filePath, StandardCharsets.UTF_8, StandardOpenOption.CREATE);

        String json = gson.toJson(game);

        JSONObject jsonObject = new JSONObject(json);

        JSONArray jsonArray = toJsonArray();

        jsonArray.put(jsonObject);

        writer.write(jsonArray.toString());

        writer.close();

        System.out.println("Game written to JSON file.");
    }

    @Override
    public void printGamesFromJson() throws IOException {
        int count = 0;
        for (Game game : fromJson()) {
            count++;
            System.out.printf("%d. %s, Ilość graczy: %d/%d, Miasto: %s\n",
                    count, game.getName(), game.getPlayers().size(), game.getMaxNumberOfPlayers(), game.getGameLocation().getTown());
        }
    }

    @Override
    public void printAsJson(Object o) {
        System.out.println(new Gson().toJson(o));
    }
}
