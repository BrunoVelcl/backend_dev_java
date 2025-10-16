package com.evidencija.application;

public enum StudentMenu {
    ID('1'),
    FIRST_NAME('2'),
    LAST_NAME('3'),
    QUIT('q');

    private final char aChar;

    StudentMenu(char aChar) {
        this.aChar = aChar;
    }

    public static StudentMenu getFromChar(char aChar){
        for(StudentMenu e : StudentMenu.values()){
            if(e.aChar == aChar){
                return e;
            }
        }
        throw new IllegalArgumentException("Option does not exist");
    }
}
