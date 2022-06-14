package com.infoshareacademy.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.infoshareacademy.model.Game;
import com.infoshareacademy.model.Location;
import com.infoshareacademy.model.Player;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.Scanner;

public class FormServiceImpl implements FormService, JsonService, GameTypeService {

    public static final String RESOURCE_PATH ="src/main/resources/games.json";

    @Override
    public Game createForm() {
        Game formGame = new Game();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj swoje imię: ");
        formGame.setGameOwner(new Player());
        formGame.getGameOwner().setName(scanner.nextLine());

        System.out.println("Podaj swojego emaila: ");
        formGame.getGameOwner().setMail(scanner.nextLine());
        formGame.addPlayerToGame(formGame.getGameOwner(), formGame);

        System.out.println("Wybierz rodzaj gry: ");
        System.out.println("1. Sport");
        System.out.println("2. Board");

        whichGameType(formGame);

        scanner = new Scanner(System.in);

        System.out.println("Podaj nazwę gry: ");
        formGame.setName(scanner.nextLine());

        System.out.println("Podaj liczbę graczy: ");
        formGame.setMaxNumberOfPlayers(scanner.nextInt());

        scanner = new Scanner(System.in);

        System.out.println("Podaj miasto: ");
        formGame.setGameLocation(new Location());
        formGame.getGameLocation().setTown(scanner.nextLine());

        //scanner = new Scanner(System.in);

        //TODO
        LocalDateTime gameDate = LocalDateTime.now();
        formGame.setDateOfGame(gameDate);
        System.out.println("Data gry (dd-mm-yyyy): " + formGame.getDateOfGame().toString());

        return formGame;
    }

    @Override
    public void closeForm(Game game) throws IOException {
        saveToJsonFile(game);
    }

    @Override
    public JSONArray toJsonArray() throws IOException {

        JSONArray jsonArray = new JSONArray(fromJson());
        return jsonArray;
    }

    @Override
    public Game[] fromJson() throws IOException {

        Gson gson = new GsonBuilder().create();

        Path filePath = Paths.get(RESOURCE_PATH);

        String file = Files.readString(filePath);

        Game[] games = gson.fromJson(file, Game[].class);

        return games;
    }

    @Override
    public void saveToJsonFile(Game game) throws IOException {

        Gson gson = new GsonBuilder().create();

        Path filePath = Paths.get(RESOURCE_PATH);

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
    public void editJsonFile(int index, Game game) throws IOException {
        Gson gson = new GsonBuilder().create();
        Path filePath = Paths.get(RESOURCE_PATH);
        Writer writer = Files.newBufferedWriter(filePath, StandardCharsets.UTF_8, StandardOpenOption.CREATE);

        String json = gson.toJson(game);
        JSONArray jsonArray = toJsonArray();
        JSONObject jsonObject = new JSONObject(json);
        jsonArray.put(index, jsonObject);

        writer.write(jsonArray.toString());
        writer.close();
    }

    @Override
    public void printGamesFromJson() throws IOException {
        int count = 0;
        for (Game game : fromJson()) {
            count++;
            System.out.printf("%d. %s, Ilość graczy: %d/%d, Miasto: %s\n",
                    count, game.getName(), game.getPlayers().size(), game.getMaxNumberOfPlayers(),
                    game.getGameLocation().getTown());
        }
    }

    @Override
    public void printAsJson(Object o) {
        System.out.println(new Gson().toJson(o));
    }
}
