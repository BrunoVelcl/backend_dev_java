package com.BookLib.domain.entity;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class SuperEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public long getId() {
        return id;
    }
}
