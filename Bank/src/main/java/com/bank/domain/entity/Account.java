package com.bank.domain.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private long id;

    @Column(name = "Username", nullable = false, unique = true, columnDefinition = "NVARCHAR(100)")
    private String username;

    @Column(name = "Balance", nullable = false)
    private BigDecimal balance;

    public Account(){};
    public Account(String username, BigDecimal balance) {
        this.username = username;
        this.balance = balance;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
