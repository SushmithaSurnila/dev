package com.springboot.university.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.springboot.university.entities.Department;
import com.springboot.university.repository.DepartmentRepository;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository deprepository;
	
	
    public ArrayList<Department> findAllDepartment() {
        return (ArrayList<Department>) deprepository.findAll();
    }
	
    public Department findAllDepartmentByID(Long depId) {
        Optional<Department> opt = deprepository.findById(depId);
        if (opt.isPresent())
            return opt.get();
        else
            return null;
    }
	
    public void addDepartment(Department department)  
	{    
	  deprepository.save(department);    
	}
    
    public void UpdateDepartment(Department department)  
	{    
	  deprepository.save(department);    
	}
    
   
	   	    
	    public void delete(Department department) {
	        deprepository.delete(department);
	    }
}
