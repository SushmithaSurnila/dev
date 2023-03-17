package com.springboot.university.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.university.entities.Faculty;
import com.springboot.university.entities.Student;
import com.springboot.university.service.FacultyService;

@RestController
public class FacultyController {
	
	@Autowired
	private FacultyService facultyservice;
	
	@GetMapping("/getallfaculty")
	public List<Faculty> getallfaculty()
	{
		return facultyservice.getAllFaculty();
	}
	
	@PostMapping("/savefaculty")
	public void addFaculty(@RequestBody Faculty faculty)
	{
		facultyservice.addFaculty(faculty);
	}
	
	@PutMapping("/updatefaculty")
	public void updateFaculty(@RequestBody Faculty faculty)
	{
		facultyservice.updateFaculty(faculty);
	}
	
	@DeleteMapping("/deletefaculty")
	public void deleteFacultyById(Long facultyId)
	{
		facultyservice.deleteFacultyById(facultyId);
	}
	
	

}
