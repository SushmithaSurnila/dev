package com.springboot.university.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.university.entities.Faculty;
import com.springboot.university.entities.Student;
import com.springboot.university.repository.FacultyRepository;

@Service
public class FacultyService {
	
	@Autowired
	private FacultyRepository repository;
	private int availableNumberOfLeaves=10;
	
	
	
	public List<Faculty> getAllFaculty()  
	{    
	List<Faculty> faculty = new ArrayList<>();    
	repository.findAll().forEach(faculty::add);    
	return faculty;    
	} 
	
	public void addFaculty(Faculty faculty)  
	{    
	repository.save(faculty);    
	}
	
	public void updateFaculty(Faculty faculty)  
	{    
	repository.save(faculty);    
	}
	
	public void deleteFacultyById(Long facultyId)  
	{    
	repository.deleteById(facultyId);    
	}
	
	//public int leaves(Faculty faculty)
	//{
		//int facultyLeaves=faculty.getLeaves();
		
		 //availableNumberOfLeaves = availableNumberOfLeaves-facultyLeaves;
		//return availableNumberOfLeaves;
	//}

}
