package com.example.education3.student.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity(name = "University")
@Table(name = "university")
public class University {

    @Id
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "university",
            targetEntity = Student.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    @JsonIgnore
    private List<Student> students;


    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    @OneToMany(mappedBy = "university",
            targetEntity = Teacher.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    @JsonIgnore
    private List<Teacher> teachers;

    public Integer getId() {
        return id;
    }

    public University setId(final Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public University setName(final String name) {
        this.name = name;
        return this;
    }

    public List<Student> getStudents() {
        return students;
    }

    public University setStudents(final List<Student> students) {
        this.students = students;
        return this;
    }

}
