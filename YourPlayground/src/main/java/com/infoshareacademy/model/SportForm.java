package com.infoshareacademy.model;

import com.infoshareacademy.service.Form;

public class SportForm implements Form {

    private Game game;

    public SportForm(Game game) {
        this.game = game;
    }

    @Override
    public void initializeForm() {
    }

    @Override
    public void closeForm() {

    }

    @Override
    public void saveToJson() {

    }
}
