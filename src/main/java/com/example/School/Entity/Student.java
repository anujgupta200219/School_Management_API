package com.example.School.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue
    int id;

    int Roll;

    String Name;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "class_name", referencedColumnName = "className"),
            @JoinColumn(name = "section", referencedColumnName = "section")
    })
    private Standard standard;
}
