package com.evidencija.application;

public enum ProgramMenu {
    ID('1'),
    NAME('2'),
    CSVET('3'),
    QUIT('q');

    private final char aChar;

    ProgramMenu(char aChar) {
        this.aChar = aChar;
    }

    public static ProgramMenu getFromChar(char aChar){
        for(ProgramMenu e : ProgramMenu.values()){
            if(e.aChar == aChar){
                return e;
            }
        }
        throw new IllegalArgumentException("Option does not exist");
    }
}
