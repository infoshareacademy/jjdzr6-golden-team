package com.infoshareacademy.exceptions;

public class GameIsFullException extends RuntimeException {
    public GameIsFullException() {
        super("The list of players is full. Unable to join!");
    }
}
