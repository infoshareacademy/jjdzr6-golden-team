package com.infoshareacademy.service;

import java.io.IOException;

public interface MenuService {

    void drawMenu();

    void continueHandler(String s);

    void exitHandler();

    void runMenu() throws IOException;

    int userInput();
}
