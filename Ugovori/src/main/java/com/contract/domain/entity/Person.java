package com.contract.domain.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdPerson;

    private String name;

//    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    @JoinTable(
//            name = "PersonContract",
//            joinColumns = @JoinColumn(name = "IdPerson"),
//            inverseJoinColumns = @JoinColumn(name = "IdContract")
//    )
    @OneToMany(mappedBy = "person", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Contract> personContracts;

    public Person(){}

    public Person(String name) {
        this.name = name;
    }

    public Long getIdPerson() {
        return IdPerson;
    }

    public String getName() {
        return name;
    }

    public Set<Contract> getPersonContracts() {
        return personContracts;
    }
}
