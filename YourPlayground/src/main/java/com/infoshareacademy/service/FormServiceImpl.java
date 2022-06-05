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
        GameForm gameForm = new GameForm();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj swoje imię: ");
        gameForm.getGameOwner().setName(scanner.nextLine());

        System.out.println("Podaj swojego emaila: ");
        gameForm.getGameOwner().setMail(scanner.nextLine());

        System.out.println("Wybierz rodzaj gry: ");
        System.out.println("1. Sport");
        System.out.println("2. Board");

        int type = scanner.nextInt();

        if(type == 1)  {
            gameForm.setType(GameType.SPORTS);
        }
        else if (type == 2) {
            gameForm.setType(GameType.BOARD);
        }
        else System.out.println("ty baranie");

        scanner = new Scanner(System.in);

        System.out.println("Podaj nazwę gry: ");
        gameForm.setName(scanner.nextLine());

        System.out.println("Podaj liczbę graczy: ");
        gameForm.setMaxNumberOfPlayers(scanner.nextInt());

        scanner = new Scanner(System.in);

        System.out.println("Podaj miasto: ");
        gameForm.getGameLocation().setTown(scanner.nextLine());

        scanner = new Scanner(System.in);

        System.out.println("Podaj datę gry (dd-mm-yyyy): ");
        gameForm.getDateOfGame().setGameDate(scanner.nextLine());

        return new Game(gameForm);
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
        for (Game game : fromJson()) {
            System.out.println(game);
        }
    }

    @Override
    public void printAsJson(Object o) {
        System.out.println(new Gson().toJson(o));
    }
}
