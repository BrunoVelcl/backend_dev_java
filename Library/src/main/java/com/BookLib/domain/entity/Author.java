package com.BookLib.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Author extends SuperEntity{

    @Column(name = "FirstName", nullable = false)
    private String firstName;

    @Column(name = "LastName", nullable = false)
    private String lastName;

    @Column(name = "Middle Name")
    private String middleName;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();

    public Author(){}

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
}
