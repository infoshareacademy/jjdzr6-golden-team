package com.infoshareacademy.service;

import com.infoshareacademy.model.Game;

import java.io.IOException;
import java.text.ParseException;

public interface FormService {
    public Game printForm() throws ParseException;
    public void closeForm();
}
