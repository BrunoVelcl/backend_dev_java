package com.contract.domain.entity;

import jakarta.persistence.*;

import java.util.Set;


@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdCompany;

    private String name;

//    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    @JoinTable(
//            name = "CompanyContract",
//            joinColumns = @JoinColumn(name = "IdCompany"),
//            inverseJoinColumns = @JoinColumn(name = "IdContract")
//    )
    @OneToMany(mappedBy = "company", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Contract> companyContracts;

    public Company(){}

    public Company(String name) {
        this.name = name;
    }

    public Long getIdCompany() {
        return IdCompany;
    }

    public String getName() {
        return name;
    }

    public Set<Contract> getCompanyContracts() {
        return companyContracts;
    }
}
