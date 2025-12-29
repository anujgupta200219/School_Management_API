package com.example.School.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student_Request {
    private int roll;
    private int className;
    private String section;
}
