package com.example.education3.student.repo;

import com.example.education3.student.entity.Student;
import com.example.education3.student.entity.Teacher;

import java.util.List;

public interface InterfaceTeacherRepo {

    List<Teacher> getList();
    void update(Teacher obj);
    void delete(Teacher obj);

    void insert(Teacher obj);
    void findById(Teacher obj);

    List<Teacher> getList(String name, String surname, String email, String university, Integer age, Integer salary);
}
