package com.evidencija.domain.entity;

import com.evidencija.application.Text;
import com.evidencija.util.ANSI;

public class Student {
    private Integer id = null;
    private final String firstName;
    private final String lastName;

    public Student(Integer id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String prettyString(){
        return Text.STAR_SEPARATOR + Text.NEW_LINE +
                "ID: " + ANSI.Color.basicString(this.id.toString(), ANSI.BasicColor.BLUE) + Text.NEW_LINE +
                "Ime: " + ANSI.Color.basicString(this.firstName, ANSI.BasicColor.BLUE) + Text.NEW_LINE +
                "Prezime " + ANSI.Color.basicString(this.lastName, ANSI.BasicColor.BLUE) + Text.NEW_LINE +
                Text.STAR_SEPARATOR;
    }
}
