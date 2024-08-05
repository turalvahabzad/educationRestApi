package com.example.education3.student.repo;

import com.example.education3.student.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyDataUniversityRepo extends JpaRepository<University, Integer> {

}
