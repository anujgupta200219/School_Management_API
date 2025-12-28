package com.example.School.Service;

import com.example.School.Entity.Standard;
import com.example.School.Repository.Standard_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Standard_Service {

    @Autowired
    private Standard_Repository standardRepository;

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
