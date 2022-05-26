package com.infoshareacademy.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.infoshareacademy.model.Game;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FormServiceImpl implements FormService, JsonService {

    public static final Path RESOURCE_PATH = Path.of("src", "main", "resources");

    public Game game;

    public FormServiceImpl(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public void initializeForm() {

    }

    @Override
    public void closeForm() {

    }

    @Override
    public JSONArray openJson() throws IOException {

        Gson gson = new GsonBuilder().create();

        Path filePath = Paths.get(RESOURCE_PATH.toString(), "games.json");

        String file = Files.readString(filePath);

        Game[] games = gson.fromJson(file, Game[].class);

        JSONArray jsonArray = new JSONArray(games);

        return jsonArray;
    }

    @Override
    public void saveToJson(Game game) throws IOException {

        Gson gson = new GsonBuilder().create();

        Path filePath = Paths.get(RESOURCE_PATH.toString(), "games.json");

        Writer writer = Files.newBufferedWriter(filePath, StandardCharsets.UTF_8, StandardOpenOption.CREATE);

        String json = gson.toJson(game);

        JSONObject jsonObject = new JSONObject(json);

        JSONArray jsonArray = openJson();

        jsonArray.put(jsonObject);

        writer.write(jsonArray.toString());

        writer.close();

        System.out.println("Game written to JSON file.");
    }

    @Override
    public void printGamesFromJson() throws IOException {
        Gson gson = new GsonBuilder().create();

        Path filePath = Paths.get(RESOURCE_PATH.toString(), "games.json");

        String file = Files.readString(filePath);

        Game[] games = gson.fromJson(file, Game[].class);

        for(Game game: games) {
            System.out.println(game);
        }
    }
}
