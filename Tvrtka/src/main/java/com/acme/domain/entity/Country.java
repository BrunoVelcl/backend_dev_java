package com.acme.domain.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Country extends SuperEntity{

    @Column(name = "Name", nullable = false, unique = true)
    private String name;

    @Column(name = "Code", nullable = false, unique = true, length = 2)
    private String code;

    @OneToMany(mappedBy = "countryOfBirth")
    Set<Worker> workersBirthCountry;

    @OneToMany(mappedBy = "country")
    Set<City> cities;

    @OneToMany(mappedBy = "country")
    Set<Manufacturer> manufacturers;

    public Country(){}

    public Country(String name, String code) {
        this.name = name;
        this.code = code;
    }
}
