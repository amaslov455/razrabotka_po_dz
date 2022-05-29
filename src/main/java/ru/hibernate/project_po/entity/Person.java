package ru.hibernate.project_po.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "person", uniqueConstraints = {@UniqueConstraint(name = "passportSeriesAndNumber", columnNames = {"passport_series", "passport_number"})})
public class Person {
    private Long id;
    private Integer passportSeries;
    private Integer passportNumber;
    private String lastName;
    private String firstName;
    private String middleName;

    public Person() {
    }

    public Person(Integer passportSeries, Integer passportNumber, String lastName, String firstName, String middleName) {
        this.passportSeries = passportSeries;
        this.passportNumber = passportNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "passport_series")
    public Integer getPassportSeries() {
        return passportSeries;
    }

    public void setPassportSeries(Integer passportSeria) {
        this.passportSeries = passportSeria;
    }

    @Column(name = "passport_number")
    public Integer getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(Integer passportNumber) {
        this.passportNumber = passportNumber;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "middle_name")
    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", passportSeries=" + passportSeries +
                ", passportNumber=" + passportNumber +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                '}';
    }
}
