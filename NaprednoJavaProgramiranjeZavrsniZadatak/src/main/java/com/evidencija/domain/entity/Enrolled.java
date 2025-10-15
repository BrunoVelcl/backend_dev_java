package com.evidencija.domain.entity;

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
                this.student.getFirstName() + " " +
                this.student.getLastName() + " " +
                this.program.getName() + " " +
                this.program.getCsvet();
    }
}
