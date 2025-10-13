package com.acme.domain.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class Manufacturer extends SuperEntity{

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true, columnDefinition = "NVARCHAR(16)")
    private String shorthandName;

    @Column(nullable = false, unique = true)
    private String identifier;

    @JoinColumn(name = "CountryID")
    @ManyToOne
    private Country country;

    @OneToMany(mappedBy = "manufacturer")
    private Set<Machine> machines;

    public Manufacturer(){}

    public Manufacturer(String name, String shorthandName, String identifier, Country country) {
        this.name = name;
        this.shorthandName = shorthandName;
        this.identifier = identifier;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getShorthandName() {
        return shorthandName;
    }

    public String getIdentifier() {
        return identifier;
    }
}
