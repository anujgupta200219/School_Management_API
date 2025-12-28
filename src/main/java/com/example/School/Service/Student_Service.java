package com.example.School.Service;

import com.example.School.DTO.Student_Response;
import com.example.School.Entity.Standard;
import com.example.School.Entity.StandardId;
import com.example.School.Entity.Student;
import com.example.School.Repository.Standard_Repository;
import com.example.School.Repository.Student_Repository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Student_Service {

    @Autowired
    private Student_Repository studentRepository;

    @Autowired
    private Standard_Repository standardRepository;

    @Transactional
    public void saveStudent(Student student){
        StandardId standardId=student.getStandard().getId();
        Optional<Standard> standards=standardRepository.findById(standardId);
        if(standards.isEmpty()){
            throw new RuntimeException("Standard does not exists");
        }
        Standard standard = standards.get();
        boolean is_roll=standard.getStudentArrayList().stream().anyMatch(s-> s.getRoll()==student.getRoll());
        if(is_roll){
            throw new RuntimeException("Roll Number already Exists");
        }
        studentRepository.save(student);
    }

    public List<Student_Response> getAllStudent(){
        return studentRepository.findAll().stream()
                .map(s-> new Student_Response(
                s.getRoll(),
                s.getName(),
                s.getStandard().getId().getClassName(),
                s.getStandard().getId().getSection()
        )).toList();
    }
}
