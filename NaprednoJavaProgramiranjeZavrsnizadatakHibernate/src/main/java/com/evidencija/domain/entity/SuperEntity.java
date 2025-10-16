package com.evidencija.domain.entity;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class SuperEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        SuperEntity that = (SuperEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

}
