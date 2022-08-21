package com.infoshareacademy.gui.menu;


import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ContinueHandler {
    public boolean continueHandler() {

        Scanner scanner = new Scanner(System.in);
        String wantToContinue;

        while (true) {
            System.out.print("Do you want to continue? Y/N: ");

            wantToContinue = scanner.nextLine();

            if (wantToContinue.equalsIgnoreCase("Y")) {
                return true;
            } else if (wantToContinue.equalsIgnoreCase("N")) {
                return false;
            } else {
                System.out.println("Select available options.\r\n");
            }
        }
    }
}
