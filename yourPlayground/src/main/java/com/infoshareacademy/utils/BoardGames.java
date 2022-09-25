package com.infoshareacademy.utils;

public enum BoardGames {

    CHESS("Chess"),
    CLUEDO("Cluedo"),
    UNO("Uno"),
    MONOPOLY("Monopoly");
    private final String value;

    BoardGames(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
