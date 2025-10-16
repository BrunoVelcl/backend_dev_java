package com.evidencija.domain.entity;

import com.evidencija.util.ANSI;

public class Enrolled {
    private final Integer id;
    private final Student student;
    private final Program program;

    public Enrolled(Integer id, Student student, Program program) {
        this.id = id;
        this.student = student;
        this.program = program;
    }

    public String prettyString(){
        return
                this.id + ". " +
                ANSI.Color.basicString(
                        this.student.getFirstName() + " " +
                                this.student.getLastName() + " "
                        , ANSI.BasicColor.BLUE) +
                this.program.getName() + " " +
                this.program.getCsvet();
    }
}
