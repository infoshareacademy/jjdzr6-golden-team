package com.infoshareacademy.utils;

public enum GameType {
    BOARD {
        @Override
        public String toString() {
            return "Board games";
        }
    },
    SPORT {
        @Override
        public String toString() {
            return "Sports games";
        }
    }
}
