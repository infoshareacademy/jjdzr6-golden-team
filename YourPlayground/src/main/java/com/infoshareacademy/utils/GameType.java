package com.infoshareacademy.utils;

public enum GameType {
    BOARD {
        @Override
        public String toString() {
            return "Board games";
        }
    },
    SPORTS {
        @Override
        public String toString() {
            return "Sports games";
        }
    }
}
