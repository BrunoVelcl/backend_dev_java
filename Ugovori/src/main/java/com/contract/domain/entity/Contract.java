package com.contract.domain.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdContract;

    private LocalDate localDate;
    private Long duration;
    private BigDecimal salary;

    @JoinColumn(name = "CompanyID")
    @ManyToOne
    private Company company;
    @JoinColumn(name = "PersonId")
    @ManyToOne
    private Person person;

//    @ManyToMany(mappedBy = "companyContracts")
//    private Set<Company> companies;
//    @ManyToMany(mappedBy = "personContracts")
//    private Set<Person> persons;


    public Contract(Long duration, BigDecimal salary, Company company, Person person) {
        this.duration = duration;
        this.salary = salary;
        this.company = company;
        this.person = person;
        this.localDate = LocalDate.now();
    }

    public Long getIdContract() {
        return IdContract;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public Long getDuration() {
        return duration;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public Company getCompany() {
        return company;
    }

    public Person getPerson() {
        return person;
    }
}
