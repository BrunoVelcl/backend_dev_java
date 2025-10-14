package com.BookLib.domain.entity;

import jakarta.persistence.*;

import java.time.Year;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Book extends SuperEntity{

    @Column(name = "BookTitle", nullable = false)
    private String title;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "BooksAuthors",
            joinColumns = {@JoinColumn(name = "BookId")},
            inverseJoinColumns = {@JoinColumn(name = "AuthorId")})
    private Set<Author> authors = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "publisherId", nullable = false)
    private Publisher publisher;

    private Year released;

    public Book(){}

    public Book(String title, Set<Author> authors, Publisher publisher, Year released) {
        this.title = title;
        this.authors = authors;
        this.publisher = publisher;
        this.released = released;
    }

    public void addAuthor(Author author) {
        this.authors.add(author);
    }
}
