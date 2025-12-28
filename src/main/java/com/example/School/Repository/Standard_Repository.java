package com.example.School.Repository;

import com.example.School.Entity.Standard;
import com.example.School.Entity.StandardId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Standard_Repository extends JpaRepository<Standard, StandardId> {
}
