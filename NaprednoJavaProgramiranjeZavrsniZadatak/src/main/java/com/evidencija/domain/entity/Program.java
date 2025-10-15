package com.evidencija.domain.entity;

import com.evidencija.util.Util;

public class Program {
    private Integer id = null;
    private final String name;
    private final Integer csvet;

    public Program(Integer id, String name, Integer csvet) {
        this.id = id;
        this.name = name;
        this.csvet = csvet;
    }

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

    public String prettyString() {
        return Util.STAR_SEPARATOR + Util.NEW_LINE +
                "ID: " + this.id + Util.NEW_LINE +
                "Naziv: " + this.name + Util.NEW_LINE +
                "CSVET: " + this.csvet + Util.NEW_LINE +
                Util.STAR_SEPARATOR;
    }
}
