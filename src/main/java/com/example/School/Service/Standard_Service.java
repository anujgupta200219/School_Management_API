package com.example.School.Service;

import com.example.School.Entity.Standard;
import com.example.School.Repository.Standard_Repository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Standard_Service {

    @Autowired
    private Standard_Repository standardRepository;

    @Transactional
    public boolean saveStandard(Standard standard){
        try{
            standardRepository.save(standard);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
