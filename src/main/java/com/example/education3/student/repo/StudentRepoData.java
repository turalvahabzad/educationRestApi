package com.example.education3.student.repo;

import com.example.education3.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepoData extends JpaRepository<Student, Integer> {


}
