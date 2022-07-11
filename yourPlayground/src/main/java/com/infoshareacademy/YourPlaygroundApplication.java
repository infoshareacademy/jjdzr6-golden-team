package com.infoshareacademy;

import com.infoshareacademy.gui.menu.ConsoleCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class YourPlaygroundApplication implements CommandLineRunner {

    @Autowired
    private List<ConsoleCommand> commands;

    public static void main(String[] args) {
        SpringApplication.run(YourPlaygroundApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        var scanner = new Scanner(new InputStreamReader(System.in));
        while (true) {
            printInfo();
            System.out.print("Your choice (number): ");
            String input = scanner.nextLine()
                    .toLowerCase(Locale.ROOT);
            commands.stream()
                    .filter(command -> command.canHandle(input))
                    .forEach(command -> {
                        try {
                            command.handle(input);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
            System.out.println();
        }
    }

    private void printInfo() {
        System.out.println("\nProvide a command to execute:\n");
        commands.stream().map(ConsoleCommand::introduce).forEach(System.out::println);
    }
}
