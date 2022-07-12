package com.infoshareacademy.service;

import com.infoshareacademy.model.Game;
import org.json.JSONArray;

import java.io.IOException;

public interface JsonService {

    JSONArray toJsonArray() throws IOException;
    Game[] fromJson() throws IOException;

    void saveToJsonFile(Game game);

    void printGamesFromJson() throws IOException;

    void printAsJson(Object o);

    void editJsonFile(int index, Game game) throws IOException;
}
