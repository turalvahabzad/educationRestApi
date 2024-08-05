package com.example.education3.student.repo;

import com.example.education3.student.entity.Student;

import java.util.List;

public interface InterfaceStudentRepo {

    List<Student> getList();
     void update(Student obj);
     void delete(Student obj);

    void insert(Student obj);
     void findById(Student obj);

     List<Student> getList(String name, String surname, String email, String university, Integer age, String password);
}
