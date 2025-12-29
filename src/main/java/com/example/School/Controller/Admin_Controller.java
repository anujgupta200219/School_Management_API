package com.example.School.Controller;


import com.example.School.DTO.Student_Request;
import com.example.School.DTO.Student_Response;
import com.example.School.Entity.Standard;
import com.example.School.Entity.Student;
import com.example.School.Service.Standard_Service;
import com.example.School.Service.Student_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/admin")
public class Admin_Controller {

    @Autowired
    private Standard_Service standardService;

    @Autowired
    private Student_Service studentService;

    @GetMapping("/getAllStudent")
    public ResponseEntity<?> getAllStudent(){
        try{

            return new ResponseEntity<>(studentService.getAllStudent(),HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>("No Student Exists!!", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/getstudentbyinfo")
    public ResponseEntity<?> getStudentByInfo(@RequestBody Student_Request studentRequest){
        Student_Response studentResponse=studentService.getStudentByInfo(studentRequest.getRoll(), studentRequest.getClassName(), studentRequest.getSection());
        if (studentResponse!=null){
            return new ResponseEntity<>(studentResponse,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Student Not Found!!",HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/savestandard")
    public ResponseEntity<?> saveStandard(@RequestBody Standard standard){
        if(standardService.saveStandard(standard)){
            return new ResponseEntity<>(" created successfully", HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>("Something Went Wrong!!",HttpStatus.FAILED_DEPENDENCY);
        }
    }

    @PostMapping("/savestudent")
    public ResponseEntity<?> saveStudent(@RequestBody Student student){
        try{
            studentService.saveStudent(student);
            return new ResponseEntity<>("Student Saved Successfully",HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.FAILED_DEPENDENCY);
        }
    }
}
