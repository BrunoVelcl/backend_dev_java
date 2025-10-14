package com.evidencija.domain.entity;

public class Program {
    private Integer id = null;
    private String name;
    private Integer csvet;

    public Program(String name, Integer csvet) {
        this.name = name;
        this.csvet = csvet;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getCsvet() {
        return csvet;
    }
}
