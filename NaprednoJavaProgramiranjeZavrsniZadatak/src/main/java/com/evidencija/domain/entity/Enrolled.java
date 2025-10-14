package com.evidencija.domain.entity;

public class Enrolled {
    private Integer id;
    private Student student;
    private Program program;

    public Enrolled(Integer id, Student student, Program program) {
        this.id = id;
        this.student = student;
        this.program = program;
    }

    public Integer getId() {
        return id;
    }

    public Student getStudentId() {
        return student;
    }

    public Program getProgramId() {
        return program;
    }
}
