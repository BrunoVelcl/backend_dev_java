package com.acme.domain.entity;

import jakarta.persistence.*;


@Entity
public class Machine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDMachine")
    private long idMachine;

    @Column(columnDefinition = "NVARCHAR(20)", nullable = false, unique = true)
    private String designation;

    @JoinColumn(name = "ManufacturerID", nullable = false)
    @ManyToOne
    private Manufacturer manufacturer;

    private long inventoryNumber;

    private short yearManufactured;

    public Machine(){};

    public Machine(String designation, Manufacturer manufacturer, long inventoryNumber, short yearManufactured) {
        this.designation = designation;
        this.manufacturer = manufacturer;
        this.inventoryNumber = inventoryNumber;
        this.yearManufactured = yearManufactured;
    }

    public long getIdMachine() {
        return idMachine;
    }

    public String getDesignation() {
        return designation;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public long getInventoryNumber() {
        return inventoryNumber;
    }

    public short getYearManufactured() {
        return yearManufactured;
    }
}
