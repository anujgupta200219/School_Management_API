package com.example.School.Repository;

import com.example.School.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Student_Repository extends JpaRepository<Student,Integer> {
    Optional<Student> findByRollAndStandard_Id_ClassNameAndStandard_Id_Section(
            int roll,
            int className,
            String section
    );
}
