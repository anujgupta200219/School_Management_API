package com.example.School.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "standard")
@Data
@NoArgsConstructor
public class Standard {

    @EmbeddedId
    private StandardId id;

    @OneToMany(mappedBy = "standard", cascade = CascadeType.ALL)
    List<Student> studentArrayList;
}
