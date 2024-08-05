package com.example.education3.student.repo;

import com.example.education3.student.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepoData extends JpaRepository<Teacher, Integer> {
}
