package com.acme.domain.entity;

import com.acme.domain.repository.ManufacturerRepository;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDManufacturer")
    long idManufacturer;

    @Column(nullable = false, unique = true)
    String name;

    @Column(nullable = false, unique = true, columnDefinition = "NVARCHAR(16)")
    String shorthandName;

    @Column(nullable = false, unique = true)
    String identifier;

    @OneToMany(mappedBy = "manufacturer")
    Set<Machine> machines;

    public Manufacturer(){}

    public Manufacturer(String name, String shorthandName, String identifier) {
        this.name = name;
        this.shorthandName = shorthandName;
        this.identifier = identifier;
    }

    public long getIdManufacturer() {
        return idManufacturer;
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
