package com.evidencija.application;

import com.evidencija.util.ANSI;

public abstract class Text {

    private static final String PROGRAM_NAME = ANSI.Color.brightBackground(ANSI.Style.bold(ANSI.Color.brightString("*****EVIDENCIJA POLAZNIKA*****", ANSI.BasicColor.BLACK)), ANSI.BasicColor.WHITE);

    public static final String MAIN_MENU =
            PROGRAM_NAME + """
     
            1. Unesite novog polaznika.
            2. Unesite novi program.
            3. Upiši polaznika.
            4. Transfer programa polaznika.
            5. Prikaz polaznika programa.
            Q. Izlaz.
            """;

    public static final String NEW_STUDENT_MENU = """
            Odaberite nacin pretrage Studenta:
            1. ID.
            2. Ime.
            3. Prezime.
            Q. Izlaz.
            """;

    public static final String NEW_PROGRAM_MENU = """
            Odaberite nacin pretrage Programa:
            1. ID.
            2. Naziv.
            3. CSVET.
            Q. Izlaz.
            """;


    public static final String SPACE = " ";
    public static final String NEW_LINE = System.lineSeparator();
    public static final String STAR_SEPARATOR = ANSI.Color.basicString("*********************************", ANSI.BasicColor.GREEN);

    public static final String ODABRAN_POLAZNIK = "Odabran polaznik: ";
    public static final String ODABRAN_PROGRAM = "Odabran program: ";
    public static final String ODABRAN_PROGRAM_ZA_ISPIS = "Odabran program za ispis: ";
    public static final String ODABRAN_PROGRAM_ZA_UPIS = "Odabran program za upis: ";


    public static final String NOTHING_WAS_FOUND = ANSI.Color.basicString("Nista nije pronadjeno.", ANSI.BasicColor.YELLOW);
    public static final String NOT_FOUND_TRY_AGAIN = NOTHING_WAS_FOUND + "Pokusati ponovno?(Y/n)";

    public static final String ENTER_FIRST_NAME = ANSI.Color.basicString("Ime: ", ANSI.BasicColor.CYAN);
    public static final String ENTER_LAST_NAME = ANSI.Color.basicString("Prezime: ", ANSI.BasicColor.CYAN);
    public static final String ENTER_TITLE = ANSI.Color.basicString("Naziv programa: ", ANSI.BasicColor.CYAN);
    public static final String ENTER_POINTS = ANSI.Color.basicString("CSVET: ", ANSI.BasicColor.CYAN);
    public static final String ENTER_ID = ANSI.Color.basicString("ID: ", ANSI.BasicColor.CYAN);
    public static final String CONFIRM_TRANSFER = ANSI.Color.basicString("Zelite li zaista prebaciti polaznika?(Y/n)", ANSI.BasicColor.CYAN);
    public static final String CONFIRM_STUDENT_REGISTRATION = ANSI.Color.basicString("Zelite li registrirati polaznika?(Y/n)", ANSI.BasicColor.CYAN);

    public static final String ADDED_SUCCESSFULLY = ANSI.Color.basicString("Uspjesno dodano!", ANSI.BasicColor.GREEN);

    public static final String ADD_FAIL = ANSI.Color.basicString("UNOS NIJE POHRANJEN", ANSI.BasicColor.RED);
    public static final String NOT_A_NUMBER = ANSI.Color.basicString("Unesena vrijednost nije broj!", ANSI.BasicColor.RED);
    public static final String INVALID_ENTRY = ANSI.Color.basicString("Unesena nevažeca vrijednost!", ANSI.BasicColor.RED);

    public static final String ADD_STUDENT_HIGHLIGHT = ANSI.Color.basicBackground(ANSI.Color.basicString("UPIS", ANSI.BasicColor.BLACK), ANSI.BasicColor.WHITE);
    public static final String REMOVE_STUDENT_HIGHLIGHT = ANSI.Color.basicBackground(ANSI.Color.basicString("ISPIS", ANSI.BasicColor.BLACK), ANSI.BasicColor.WHITE);

}
