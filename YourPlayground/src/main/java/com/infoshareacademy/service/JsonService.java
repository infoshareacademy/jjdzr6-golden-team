package com.infoshareacademy.service;

import com.infoshareacademy.model.Game;
import org.json.*;

import java.io.IOException;

public interface JsonService {
    public JSONArray openJson() throws IOException;
    public void saveToJson(Game game) throws IOException;
    public void printGamesFromJson() throws IOException;
}
