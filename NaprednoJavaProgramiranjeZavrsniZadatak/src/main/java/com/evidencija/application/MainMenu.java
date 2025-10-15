package com.evidencija.application;

public enum MainMenu {
    NEW_STUDENT('1'),
    NEW_PROGRAM('2'),
    REGISTER_STUDENT('3'),
    MOVE_STUDENT('4'),
    PRINT_ENROLLED('5'),
    QUIT('q');
    
    private final char aChar;

    MainMenu(char aChar) {
        this.aChar = aChar;
    }

    public static MainMenu getFromChar(char aChar){
        for(MainMenu e : MainMenu.values()){
            if(e.aChar == aChar){
                return e;
            }
        }
        throw new IllegalArgumentException("Option does not exist");
    }
}
