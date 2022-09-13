package com.bae.student_management.entities;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class Student {

    //This is the ID column, and ID is generated using @GeneratedValue
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //This is the first name column, it can't be null
    @Column(nullable = false)
    private String firstName;

    //This is the second name column, it can't be null
    @Column(nullable = false)
    private String secondName;

    // The minimum age for a student is 11, the maximum is 16
    @Min(11)
    @Max(16)
    @Column(nullable = false)
    private int age;

    //A phone number can only be 11 numbers long
    @Column(nullable = false)
    private String contactNumber;

    @Column(nullable = false)
    private String email;

    //Default constructor
    public Student() {}

    //For creating employees
    public Student(String firstName, String secondName,
                   int age, String contactNumber, String email) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.contactNumber = contactNumber;
        this.email = email;
    }

    //For testing
    public Student(long id, String firstName,
                   String secondName, int age, String contactNumber,
                   String email) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.contactNumber = contactNumber;
        this.email = email;
    }

    //Getters and Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



}
