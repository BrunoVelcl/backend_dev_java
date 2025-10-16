package com.evidencija.domain.entity;

import com.evidencija.application.Text;
import com.evidencija.util.ANSI;

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
        return Text.STAR_SEPARATOR + Text.NEW_LINE +
                "ID: " + ANSI.Color.basicString(this.id.toString(), ANSI.BasicColor.MAGENTA) + Text.NEW_LINE +
                "Naziv: " + ANSI.Color.basicString(this.name, ANSI.BasicColor.MAGENTA) + Text.NEW_LINE +
                "CSVET: " + ANSI.Color.basicString(this.csvet.toString(), ANSI.BasicColor.MAGENTA) + Text.NEW_LINE +
                Text.STAR_SEPARATOR;
    }
}
