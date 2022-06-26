package com.infoshareacademy.service;

import com.infoshareacademy.utils.GameType;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuServiceImpl implements MenuService {

    private boolean wantToExit = false;
    private GameType gameType;

    public void printGameTypes () {
        System.out.println("1. " + gameType.BOARD);
        System.out.println("2. " + gameType.SPORTS);
    }
    @Override
    public void drawMenu() {
        System.out.println("YourPlayground\r\n"
                + "***************\r\n"
                + "1. Join game\r\n"
                + "2. Create game\r\n"
                + "3. Show map\r\n"
                + "4. Player profile\r\n"
                + "5. Exit");
    }

    @Override
    public void continueHandler(String s) {
        String wantToContinue;
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.print("Do you want to continue? Y/N: ");

            wantToContinue = scanner.nextLine();

            if (wantToContinue.equalsIgnoreCase("Y")) {
                //TODO
                System.out.println(s + "\r\n");
                break;
            } else if (wantToContinue.equalsIgnoreCase("N")) {
                break;
            } else {
                System.out.println("Select available options.\r\n");
            }
        }
    }

    @Override
    public void exitHandler() {
        String exit;
        boolean goBack = false;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Do you really want to exit? Y/N: ");

            exit = sc.nextLine();

            if (exit.equalsIgnoreCase("Y")) {
                System.out.println("Sorry to see you go.");
                System.out.println("Come back soon!");
                wantToExit = true;
                goBack = true;
            } else if (exit.equalsIgnoreCase("N")) {
                wantToExit = false;
                goBack = true;
                System.out.println();
            } else {
                System.out.println("Select available options.\r\n");
            }
        } while (!goBack);
    }

    @Override
    public void runMenu() throws IOException {
        do {
            drawMenu();

            GameServiceImpl gameService = new GameServiceImpl();
            FormServiceImpl formService = new FormServiceImpl();

            switch (userInput()) {
                case 1:
                    continueHandler("You are about to join a game...");
                    gameService.joinGame();
                    break;
                case 2:
                    continueHandler("Create game:");
                    formService.closeForm(formService.createForm());
                    break;
                case 3:
                    continueHandler("Map soon");
                    break;
                case 4:
                    continueHandler("Player configuration soon");
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

    @Override
    public int userInput() {
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
}
