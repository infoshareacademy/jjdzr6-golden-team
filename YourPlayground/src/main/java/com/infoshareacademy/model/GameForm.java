package com.infoshareacademy.model;

import com.infoshareacademy.service.FormServiceImpl;
import com.infoshareacademy.utils.GameType;

import java.util.List;

public class GameForm extends FormServiceImpl {

    private String name;
    private GameType type;
    private int maxNumberOfPlayers;
    private List<Player> players;
    private Location gameLocation;
    private DateOfGame dateOfGame;
    private Player gameOwner;

    public GameForm(Game game) {
        super(game);
    }

}
