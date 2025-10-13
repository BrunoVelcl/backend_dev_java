package com.acme.domain.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Department extends SuperEntity{

    @Column(name = "Name", nullable = false, unique = true)
    private String name;

    @Column(name = "Abbreviation", nullable = false, unique = true, length = 5)
    private String abbreviation;

    @OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
    private Set<ProcessStep> processSteps = new HashSet<>();

    @OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
    private Set<Worker> workers;

    public Department(){};

    public Department(String name, String abbreviation) {
        this.name = name;
        this.abbreviation = abbreviation;
    }

}
