package com.example.education3.student.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicUpdate;


@Entity(name = "MyStudent")
@Table(name = "student")
@DynamicUpdate
@NamedQuery(name = "findByName", query = "select s from MyStudent s where s.firstName=:name")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="name")
    private String firstName;
    private String surname;
    private Integer age;

    private String email;
    private String password;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "university_id", nullable = false)
    private University university;


    public Integer getId() {
        return id;
    }

    public Student setId(final Integer id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Student setFirstName(final String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public Student setSurname(final String surname) {
        this.surname = surname;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public Student setAge(final Integer age) {
        this.age = age;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Student setEmail(final String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Student setPassword(final String password) {
        this.password = password;
        return this;
    }

    public University getUniversity() {
        return university;
    }

    public Student setUniversity(final University university) {
        this.university = university;
        return this;
    }

}