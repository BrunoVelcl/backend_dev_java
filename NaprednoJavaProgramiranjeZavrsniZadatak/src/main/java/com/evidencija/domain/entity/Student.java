package com.evidencija.domain.entity;

import com.evidencija.util.Util;

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
        return Util.STAR_SEPARATOR + Util.NEW_LINE +
                "ID: " + this.id + Util.NEW_LINE +
                "Ime: " + this.firstName + Util.NEW_LINE +
                "Prezime " + this.lastName + Util.NEW_LINE +
                Util.STAR_SEPARATOR;
    }
}
