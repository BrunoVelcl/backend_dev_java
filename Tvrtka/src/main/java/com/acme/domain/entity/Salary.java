package com.acme.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
public class Salary extends SuperEntity {

    @Column(name = "Label", unique = true, nullable = false)
    private GreekAlphabet label;

    @Column(name = "Amount", nullable = false)
    private BigDecimal amount;

    public Salary(){}

    public Salary(GreekAlphabet label, BigDecimal amount) {
        this.label = label;
        this.amount = amount;
    }
}
