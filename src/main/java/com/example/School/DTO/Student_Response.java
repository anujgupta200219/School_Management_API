package com.example.School.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student_Response {

    private int roll;
    private String name;
    private int className;
    private String section;
}