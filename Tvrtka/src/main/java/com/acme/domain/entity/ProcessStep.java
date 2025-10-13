package com.acme.domain.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class ProcessStep extends SuperEntity{

    @Column(name = "Name", nullable = false, unique = true)
    private String name;

    @Column(name = "Abbreviation", nullable = false, unique = true, length = 15)
    private String abbreviation;

    @ManyToOne
    @JoinColumn(name = "DepartmentID")
    private Department department;

    @OneToMany(mappedBy = "workplace", fetch = FetchType.EAGER)
    private Set<Worker> workers;

    public ProcessStep(){}

    public ProcessStep(String name, String abbreviation) {
        this.name = name;
        this.abbreviation = abbreviation;
    }

    public ProcessStep(String name, String abbreviation, Department department) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

}
