package com.evidencija.domain.entity;

import com.evidencija.application.Text;
import com.evidencija.util.ANSI;
import com.evidencija.util.Util;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "ProgramObrazovanja")
public class Program extends SuperEntity {

    @Column(name = "Naziv", nullable = false, length = 100)
    private String name;

    @Column(name = "CSVET", nullable = false, length = 100)
    private Integer csvet;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "Upis",
            joinColumns = {@JoinColumn(name = "IDProgramObrazovanja")},
            inverseJoinColumns = {@JoinColumn(name = "IDPolaznik")}
    )
    private Set<Student> students;

    public Program() {
    }

    public Program(String name, Integer csvet) {
        this.name = name;
        this.csvet = csvet;
        this.students = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public Integer getCsvet() {
        return csvet;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void removeStudent(Student student) {
        this.students.remove(student);
    }

    public String prettyString() {
        return Text.STAR_SEPARATOR + Text.NEW_LINE +
                "ID: " + ANSI.Color.basicString(String.valueOf(super.getId()), ANSI.BasicColor.MAGENTA) + Text.NEW_LINE +
                "Naziv: " + ANSI.Color.basicString(this.name, ANSI.BasicColor.MAGENTA) + Text.NEW_LINE +
                "CSVET: " + ANSI.Color.basicString(this.csvet.toString(), ANSI.BasicColor.MAGENTA) + Text.NEW_LINE +
                Text.STAR_SEPARATOR;
    }

    public String printEnrolled() {
        StringBuilder sb = Util.sb;
        sb.setLength(0);
        sb.append(Text.STAR_SEPARATOR).append(Text.NEW_LINE);
        for (Student s : this.students) {
            Util.sb
                    .append(ANSI.Color.basicString(s.getFirstName(), ANSI.BasicColor.BLUE))
                    .append(Text.SPACE)
                    .append(ANSI.Color.basicString(s.getLastName(), ANSI.BasicColor.BLUE))
                    .append(Text.SPACE)
                    .append(ANSI.Color.basicString(this.getName(), ANSI.BasicColor.YELLOW))
                    .append(Text.SPACE)
                    .append(this.getCsvet())
                    .append(Text.NEW_LINE);
        }
        sb.append(Text.STAR_SEPARATOR).append(Text.NEW_LINE);
        return sb.toString();
    }

}
