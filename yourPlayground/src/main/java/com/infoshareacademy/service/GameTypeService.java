package com.infoshareacademy.service;

import com.infoshareacademy.entity.Game;
import com.infoshareacademy.utils.GameType;
import java.util.Scanner;


public interface GameTypeService {
    default void whichGameType(Game game) {
        Scanner scanner = new Scanner(System.in);
        int type = scanner.nextInt();
        if (type == 1) {
            game.setType(GameType.SPORTS);
        } else if (type == 2) {
            game.setType(GameType.BOARD);
        } else {
            System.out.println("ty baranie");
        }

    }
}
