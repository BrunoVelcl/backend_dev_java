package com.acme.domain.entity;

import jakarta.persistence.Column;

import java.util.Date;

public class Contract extends SuperEntity{

    @Column(name = "ContractIdentifier", unique = true, nullable = false, updatable = false)
    private long contractIdentifier;

    @Column(name = "ContractType", nullable = false, updatable = false)
    private ContractType contractType;

    @Column(name = "active", nullable = false)
    private boolean active;

    @Column(name = "WorkerId", nullable = false, updatable = false)
    private Worker worker;

    @Column(name = "PayGrade", nullable = false, updatable = false)
    private Salary salary;

    @Column(name = "ShiftGroup", nullable = false)
    private ShiftGroup shiftGroup;

    @Column(name = "startDate", nullable = false, updatable = false)
    private Date startDate;

    @Column(name = "startDate", updatable = false)
    private Date expiryDate;

    @Column(name = "startDate", nullable = false, updatable = false)
    private Date signedDate;

    public Contract(long contractIdentifier, ContractType contractType, boolean active, Worker worker, Salary salary, ShiftGroup shiftGroup, Date startDate, Date expiryDate, Date signedDate) {
        this.contractIdentifier = contractIdentifier;
        this.contractType = contractType;
        this.active = active;
        this.worker = worker;
        this.salary = salary;
        this.shiftGroup = shiftGroup;
        this.startDate = startDate;
        this.expiryDate = expiryDate;
        this.signedDate = signedDate;
    }

    public enum ContractType{INDEFINITE, TRIAL, FIXED_DURATION, INTERNSHIP}
}
