package com.acme.domain.entity;

import jakarta.persistence.Entity;

@Entity
public class ShiftGroup extends SuperEntity {

    private Shift group;

    public ShiftGroup(Shift group) {
        this.group = group;
    }

    public enum Shift{A, B, C, D, E}
}


