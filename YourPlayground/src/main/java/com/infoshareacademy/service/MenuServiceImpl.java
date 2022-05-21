package com.infoshareacademy.service;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuServiceImpl implements MenuService{

    private boolean wantToExit = false;
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
    public void exitHandler() {
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

    @Override
    public void runMenu() {
        do {
            drawMenu();

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
