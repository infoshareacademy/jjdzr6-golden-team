package com.infoshareacademy.gui;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    // Fields
    private boolean wantToExit = false;

    //region Methods

    /**
     * Handles menu service
     */
    public void runMenu() {
        do {
            mainMenu();

            switch(userInput()) {
                case 1:
                    System.out.println("You chose 1\r\n");
                    break;
                case 2:
                    System.out.println("You chose 2\r\n");
                    break;
                case 3:
                    System.out.println("You chose 3\r\n");
                    break;
                case 4:
                    System.out.println("You chose 4\r\n");
                    break;
                case 5:
                    exitHandler();
                    break;
                default:
                    System.out.println("Select available options.\r\n");
                    break;
            }

        } while (!wantToExit);
    }

    /**
     * Handles exiting from the program.
     * Takes user input.
     * If user types Y, program closes.
     * If user types N, returns to main menu.
     */
    private void exitHandler() {
        String exit;
        boolean goBack = false;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.print("Do you really want to exit? Y/N: ");

            exit = sc.nextLine();

            if(exit.equalsIgnoreCase("Y")) {
                System.out.println("Sorry to see you go.");
                System.out.println("Come back soon!");
                wantToExit = true;
                goBack = true;
            }
            else if(exit.equalsIgnoreCase("N")) {
                wantToExit = false;
                goBack = true;
                System.out.println();
            } else {
                System.out.println("Select available options.\r\n");
            }
        } while(!goBack);
    }

    /**
     * Displays main menu
     */
    private void mainMenu() {
        System.out.println("YourPlayground\r\n"
                + "***************\r\n"
                + "1. Join game\r\n"
                + "2. Create game\r\n"
                + "3. Show map\r\n"
                + "4. Player profile\r\n"
                + "5. Exit");
    }

    /**
     * Takes user input
     * @return input that user provides
     */
    private int userInput() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.print("Your choice: ");

        try {
            choice = scanner.nextInt();
        } catch (InputMismatchException e) {
            choice = 0;
        }

        return choice;
    }

    //endregion
}
