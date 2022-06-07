package com.infoshareacademy.service;

import com.infoshareacademy.model.Game;
import org.json.*;

import java.io.IOException;

public interface JsonService {

    public JSONArray toJsonArray() throws IOException;
    public Game[] fromJson() throws IOException;

    public void saveToJsonFile(Game game) throws IOException;

    public void printGamesFromJson() throws IOException;

    public void printAsJson(Object o);

    public void editJsonFile(int index, Game game) throws IOException;
}
