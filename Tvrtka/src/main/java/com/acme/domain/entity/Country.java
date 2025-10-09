package com.acme.domain.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Name", nullable = false, unique = true)
    private String name;

    @Column(name = "Code", nullable = false, unique = true, length = 2)
    private String code;

    @OneToMany(mappedBy = "countryOfBirth")
    Set<Worker> workersBirthCountry;

    public Country(){}

    public Country(String name, String code) {
        this.name = name;
        this.code = code;
    }
}
