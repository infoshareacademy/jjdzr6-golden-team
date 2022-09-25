package com.infoshareacademy.utils;

public enum SportGames {

    FOOTBALL("Football"),
    VOLLEYBALL("Volleyball"),
    BASKETBALL("Basketball");
    private final String value;

    SportGames(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
