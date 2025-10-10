package com.acme.domain.entity;

import jakarta.persistence.*;

@Entity
public class ProcessStep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Name", nullable = false, unique = true)
    String name;

    @Column(name = "Abbreviation", nullable = false, unique = true, length = 15)
    String abbreviation;

    public ProcessStep(){};
    public ProcessStep(String name, String abbreviation) {
        this.name = name;
        this.abbreviation = abbreviation;
    }
}
