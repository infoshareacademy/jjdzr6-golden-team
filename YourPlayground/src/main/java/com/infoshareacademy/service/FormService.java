package com.infoshareacademy.service;

import com.infoshareacademy.model.Game;

import java.io.IOException;
import java.text.ParseException;

public interface FormService {
    public Game createForm();
    public void closeForm(Game game) throws IOException;
}
