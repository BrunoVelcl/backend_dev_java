package com.acme.domain.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Worker extends SuperEntity{

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

    @Column(name = "FathersFirstName")
    private String fatherFirstname;

    @Column(name = "FathersLastName")
    private String fatherLastname;

    @Column(name = "MothersFirstName")
    private String motherFirstName;

    @Column(name = "MothersLastName")
    private String motherLastName;

    @Column (name = "PhoneNumber", unique = true)
    private Long phoneNumber = null;

    @Column(name = "E-mail", unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "DepartmentID")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "ProcessStepID")
    private ProcessStep workplace;


    public Worker(){}

    public Worker(String firstName, String lastName, String middleName, String idNumber, Date dob, Country countryOfBirth, City cityOfBirth, Gender gender) {
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
        this.countryOfBirth = cityOfBirth.getCountry();
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

    public void setFatherFirstname(String fatherFirstname) {
        this.fatherFirstname = fatherFirstname;
    }

    public void setMotherFirstName(String motherFirstName) {
        this.motherFirstName = motherFirstName;
    }

    public void setFatherLastname(String fatherLastname) {
        this.fatherLastname = fatherLastname;
    }

    public void setMotherLastName(String motherLastName) {
        this.motherLastName = motherLastName;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setWorkplace(ProcessStep workplace) {
        this.workplace = workplace;
        this.department = workplace.getDepartment();
    }

    public enum Gender{MALE, FEMALE, OTHER};
}
