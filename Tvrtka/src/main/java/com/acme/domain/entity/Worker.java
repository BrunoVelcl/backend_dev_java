package com.acme.domain.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDWorker")
    private long idWorker;

    @Column(name = "FirstName", nullable = false)
    private String firstName;

    @Column(name = "LastName", nullable = false)
    private String lastName;

    @Column(name = "MiddleName")
    private String middleName = null;

    @Column(name = "IDNumber", nullable = false, unique = true, comment = "Government issued unique identifier.")
    private String idNumber;

    @Column(name = "DOB", nullable = false)
    private Date dob;

    @JoinColumn(name = "CountryOfBirthId")
    @ManyToOne
    private Country countryOfBirth = null;

    @JoinColumn(name = "CityOfBirthID")
    @ManyToOne
    private City cityOfBirth = null;

    @Column(name = "Gender", nullable = false)
    private Gender gender;

    public Worker(){}

    public Worker(long idWorker, String firstName, String lastName, String middleName, String idNumber, Date dob, Country countryOfBirth, City cityOfBirth, Gender gender) {
        this.idWorker = idWorker;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.idNumber = idNumber;
        this.dob = dob;
        this.countryOfBirth = countryOfBirth;
        this.cityOfBirth = cityOfBirth;
        this.gender = gender;
    }


    public Worker(String firstName, String lastName, String idNumber, Date dob, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.dob = dob;
        this.gender = gender;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setCountryOfBirth(Country countryOfBirth) {
        this.countryOfBirth = countryOfBirth;
    }

    public void setCityOfBirth(City cityOfBirth) {
        this.cityOfBirth = cityOfBirth;
    }

    public long getIdWorker() {
        return idWorker;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public Date getDob() {
        return dob;
    }

    public Country getCountryOfBirth() {
        return countryOfBirth;
    }

    public City getCityOfBirth() {
        return cityOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public enum Gender{MALE, FEMALE, OTHER};
}
