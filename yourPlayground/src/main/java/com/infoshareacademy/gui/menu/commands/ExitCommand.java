package com.infoshareacademy.gui.menu.commands;

import static java.util.Objects.requireNonNull;

import java.util.Locale;

import com.infoshareacademy.gui.menu.ConsoleCommand;
import com.infoshareacademy.gui.menu.ContinueHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(5)
class ExitCommand implements ConsoleCommand {

    @Autowired
    ContinueHandler continueHandler;

    private final String input;
    private final ApplicationContext context;

    ExitCommand (ApplicationContext context) {
        this.input = requireNonNull("5").toLowerCase(Locale.ROOT);
        this.context = context;
    }

    @Override
    public boolean canHandle(String input) {
        return this.input.equals(input.toLowerCase(Locale.ROOT));
    }

    @Override
    public void handle(String input) {
        if(continueHandler.continueHandler()){
            System.exit(0);
        }

    }

    @Override
    public String introduce() {
        return input + ". Exit";
    }
}
