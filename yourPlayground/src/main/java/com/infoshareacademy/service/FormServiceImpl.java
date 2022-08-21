package com.infoshareacademy.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.infoshareacademy.entity.Game;
import com.infoshareacademy.entity.Location;
import com.infoshareacademy.entity.Player;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Component
public class FormServiceImpl implements FormService, JsonService, GameTypeService {

    public static final String RESOURCE_PATH = "YourPlayground/src/main/resources/games.json";

    @Override
    public Game createForm() {
        Game formGame = new Game();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj swoje imię: ");
        formGame.setGameOwner(new Player());
        formGame.getGameOwner().setUsername(scanner.nextLine());

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

        scanner = new Scanner(System.in);

        System.out.println("Podaj datę gry (dd-mm-yyyy hh:mm): ");
        String gameDate = scanner.nextLine();
        formGame.setDateOfGame(parseDate(gameDate));

        return formGame;
    }

    @Override
    public void closeForm(Game game) throws IOException {
        saveToJsonFile(game);
    }

    @Override
    public JSONArray toJsonArray() throws IOException {
        return new JSONArray(fromJson());
    }

    @Override
    public Game[] fromJson() throws IOException {

        Gson gson = new GsonBuilder().create();

        Path filePath = Paths.get(RESOURCE_PATH);

        String file = Files.readString(filePath);

        return gson.fromJson(file, Game[].class);
    }

    @Override
    public void saveToJsonFile(Game game) {

        Gson gson = new GsonBuilder().create();

        Writer writer = null;
        try {
            Path filePath = Paths.get(RESOURCE_PATH);

            writer = Files.newBufferedWriter(filePath, StandardCharsets.UTF_8, StandardOpenOption.CREATE);

            String json = gson.toJson(game);

            JSONObject jsonObject = new JSONObject(json);

            JSONArray jsonArray = toJsonArray();

            jsonArray.put(jsonObject);

            writer.write(jsonArray.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Game written to JSON file.");
    }

    @Override
    public void editJsonFile(int index, Game game) throws IOException {
        Gson gson = new GsonBuilder().create();

        Writer writer = null;

        try {
            Path filePath = Paths.get(RESOURCE_PATH);

            writer = Files.newBufferedWriter(filePath, StandardCharsets.UTF_8, StandardOpenOption.CREATE);

            String json = gson.toJson(game);

            JSONArray jsonArray = toJsonArray();

            JSONObject jsonObject = new JSONObject(json);

            jsonArray.put(index, jsonObject);

            writer.write(jsonArray.toString());

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            if (writer != null) {

                try {
                    writer.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
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

    public List<Game> printGamesFromJsonStr() throws IOException {
        return Arrays.asList(fromJson());
    }

    @Override
    public void printAsJson(Object o) {
        System.out.println(new Gson().toJson(o));
    }

    public LocalDateTime parseDate (String stringDate) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return LocalDateTime.parse(stringDate, formatter);
    }
}
