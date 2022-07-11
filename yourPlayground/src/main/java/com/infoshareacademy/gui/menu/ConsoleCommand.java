package com.infoshareacademy.gui.menu;

import java.io.IOException;

public interface ConsoleCommand {

    boolean canHandle(String input);

    void handle(String input) throws IOException;

    String introduce();
}
