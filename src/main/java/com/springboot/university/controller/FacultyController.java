package com.springboot.university.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.university.entities.Faculty;
import com.springboot.university.entities.Student;
import com.springboot.university.exception.FacultyNotFoundException;
import com.springboot.university.exception.StudentNotFoundException;
import com.springboot.university.service.FacultyService;

import jakarta.validation.Valid;

@RestController
@Validated
public class FacultyController {
	
	@Autowired
	private FacultyService facultyservice;
	
	@GetMapping("/getallfaculty")
	public ResponseEntity<List<Faculty>> getallfaculty() throws FacultyNotFoundException
	{
		return ResponseEntity.ok(facultyservice.getAllFaculty());
	}
	
	@PostMapping("/savefaculty")
	public ResponseEntity<List<Faculty>> addFaculty(@RequestBody @Valid List<Faculty> facultys) throws StudentNotFoundException 
	{
		return ResponseEntity.ok(facultyservice.addFaculty(facultys));
	}
	
	@GetMapping("faculty/findbyId/{facultyId}")
	public ResponseEntity<Optional<Faculty>> getFacultyById(@PathVariable Long facultyId) throws FacultyNotFoundException {
		
		return ResponseEntity.ok(facultyservice.getFacultyById(facultyId));
		
	}
	
	@PutMapping("/update/faculty/by/{facultyId}")
	public ResponseEntity<String> updatefaculty(@PathVariable Long facultyId,@RequestBody List<Faculty> facultyList)  {
		
	     List<Faculty> updateFacultyList=facultyservice.updatefaculty(facultyId,facultyList);
	     return ResponseEntity.ok("faculty details updated");
	     
	       
	}
	
	@PutMapping("/updatefaculty/{facultyId}")
	public ResponseEntity<String> updateLeaves(@PathVariable Long facultyId, @RequestBody Faculty faculty) throws Exception
	{
			
		 try{
			    return new ResponseEntity(facultyservice.updateLeaves(facultyId, faculty), HttpStatus.OK);
			 }
			catch(Exception Exception ){
			  return new ResponseEntity(Exception.getMessage(), HttpStatus.CONFLICT);
			 }
		
				
	}
	
	@DeleteMapping("/deletefaculty/{facultyId}")
	public ResponseEntity<Void> deleteFacultyById(@PathVariable Long facultyId) throws FacultyNotFoundException
	{
		try {
			facultyservice.deleteFacultyById(facultyId);
			return ResponseEntity.noContent().build();
		}catch(FacultyNotFoundException exp1) {
			return new ResponseEntity(exp1.getMessage(), HttpStatus.NOT_FOUND);
		}
		
	}
	
	

}
