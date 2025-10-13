package com.acme.domain.entity;

import jakarta.persistence.*;

@Entity
public class City extends SuperEntity{

    @Column(name = "Name", nullable = false)
    private String name;

    @JoinColumn(name = "CountryID")
    @ManyToOne
    private Country country;

    public City(){}

    public City(String name, Country country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }
}
