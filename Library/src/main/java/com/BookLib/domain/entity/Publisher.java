package com.BookLib.domain.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Publisher extends SuperEntity{

    @Column(name = "PublisherName")
    private String name;

    @OneToMany(mappedBy = "publisher")
    private Set<Book> books;

    public Publisher(){}

    public Publisher(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
