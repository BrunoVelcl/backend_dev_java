package com.evidencija.domain.entity;

import com.evidencija.application.Text;
import com.evidencija.util.ANSI;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "Polaznik")
public class Student extends SuperEntity{

    @Column(name = "Ime", nullable = false, length = 100)
    private String firstName;

    @Column(name = "Prezime", nullable = false, length = 100)
    private String lastName;

    @ManyToMany(mappedBy = "students")
    private Set<Program> programs;


    public Student(){}
    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.programs = new HashSet<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Set<Program> getPrograms() {
        return programs;
    }

    public String prettyString(){
        return Text.STAR_SEPARATOR + Text.NEW_LINE +
                "ID: " + ANSI.Color.basicString(String.valueOf(super.getId()), ANSI.BasicColor.BLUE) + Text.NEW_LINE +
                "Ime: " + ANSI.Color.basicString(this.firstName, ANSI.BasicColor.BLUE) + Text.NEW_LINE +
                "Prezime " + ANSI.Color.basicString(this.lastName, ANSI.BasicColor.BLUE) + Text.NEW_LINE +
                Text.STAR_SEPARATOR;
    }
}
