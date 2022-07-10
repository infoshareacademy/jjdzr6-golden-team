package com.infoshareacademy;

import com.infoshareacademy.gui.Menu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class YourPlaygroundApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(YourPlaygroundApplication.class, args);
        Menu menu = new Menu();
        menu.runMenu();
    }
}
