package com.example.School.Repository;

import com.example.School.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Student_Repository extends JpaRepository<Student,Integer> {
}
