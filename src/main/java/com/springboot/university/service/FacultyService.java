package com.springboot.university.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.springboot.university.entities.Faculty;
import com.springboot.university.entities.Student;
import com.springboot.university.exception.FacultyAlreadyExistsException;
import com.springboot.university.exception.FacultyNotFoundException;
import com.springboot.university.exception.StudentAlreadyExistsException;
import com.springboot.university.exception.StudentNotFoundException;
import com.springboot.university.repository.FacultyRepository;
import com.springboot.university.repository.StudentRepository;

@Service
public class FacultyService {
	
	@Autowired
	private FacultyRepository facultyRepository;
	
	public List<Faculty> getAllFaculty() throws FacultyNotFoundException  
	{    
		List<Faculty> facultys=facultyRepository.findAll();
		if(facultys.isEmpty()) {
			throw new FacultyNotFoundException("No faculty found");
		}
		return facultys;
	   
	} 
	
	public List<Faculty> addFaculty(List<Faculty> facultys) throws StudentNotFoundException 
	{  
		
		if(facultys==null || facultys.isEmpty())
		{
			throw new StudentNotFoundException("No student found");
		}
		
		List<Faculty> savedfaculty=facultyRepository.saveAll(facultys);
		return savedfaculty;
	}
	
	public Optional<Faculty> getFacultyById(Long facultyId) throws FacultyNotFoundException 
    {
		Optional<Faculty> faculty=facultyRepository.findById(facultyId);
		if(faculty.isPresent()){
			return faculty;
		}
		else{
			throw new FacultyNotFoundException("faculty not found with id:");
		}
		  		   
	}
	
	public List<Faculty> updatefaculty(Long facultyId,List<Faculty> facultyList) 
	{	
		List<Faculty> updateFacultyList=facultyRepository.saveAll(facultyList);
		return updateFacultyList;
		
	}
	
	
	
	public Faculty updateLeaves(Long facultyId, Faculty faculty) throws Exception
	{
		
		Faculty ft=facultyRepository.findById(faculty.getFacultyId())
				.orElseThrow(()->new StudentNotFoundException("No faculty with id"));
		if(faculty.getName()!=null)		{
			ft.setName(faculty.getName());
	  }
		
		if(faculty.getLeaves()!=0)
		
			if(faculty.getLeaves()<=ft.getAvailableNumberOfLeaves())
			{
				faculty.setAvailableNumberOfLeaves(ft.getAvailableNumberOfLeaves()-faculty.getLeaves());
				ft.setLeaves(faculty.getAvailableNumberOfLeaves());
			}
			else
			{
				throw new Exception("Leaves cannot be granted due to insufficient leave balance");
			}
			
		
		return facultyRepository.save(faculty);
	
		
		
			
	}
	public void deleteFacultyById(Long facultyId) throws FacultyNotFoundException  
	{  
		Optional<Faculty> faculty=facultyRepository.findById(facultyId);
		if(faculty.isPresent()){
			facultyRepository.deleteById(facultyId);  
		}
		else{
			throw new FacultyNotFoundException("faculty not found with id:");
		}
	  
	}

}
