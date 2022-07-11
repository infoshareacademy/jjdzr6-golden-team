package com.infoshareacademy.gui.menu.commands;

import com.infoshareacademy.gui.menu.ConsoleCommand;
import com.infoshareacademy.gui.menu.ContinueHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Locale;

import static java.util.Objects.requireNonNull;

@Component
@Order(3)
class ShowMapCommand implements ConsoleCommand {

    @Autowired
    ContinueHandler continueHandler;

    private final String input;
    private final ApplicationContext context;

    ShowMapCommand (ApplicationContext context) {
        this.input = requireNonNull("3").toLowerCase(Locale.ROOT);
        this.context = context;
    }

    @Override
    public boolean canHandle(String input) {
        return this.input.equals(input.toLowerCase(Locale.ROOT));
    }

    @Override
    public void handle(String input) throws IOException {
        if(continueHandler.continueHandler()) {
            System.out.println("Map soon!");
        }
    }

    @Override
    public String introduce() {
        return input + ". Show map";
    }
}
