package com.springboot.university.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.springboot.university.entities.Student;
import com.springboot.university.exception.StudentAlreadyExistsException;
import com.springboot.university.exception.StudentNotFoundException;
import com.springboot.university.service.Studentservice;

import jakarta.validation.Valid;

@RestController
@Validated
public class StudentController {
	
	@Autowired
	private Studentservice studentService;

	
	@GetMapping("/student")
	public ResponseEntity<List<Student>> getAllStudents() throws StudentNotFoundException  
	{    
		return ResponseEntity.ok(studentService.getAllStudent());
	
	}	
	
	@PostMapping("/save")
	public ResponseEntity<String> addStudent(@RequestBody @Valid Student student) throws StudentAlreadyExistsException
	{
		studentService.addStudent(student);
		return ResponseEntity.ok("Student details saved");
			
	}
	
	
	@GetMapping("student/findbyId/{studentid}")
	public ResponseEntity<Optional<Student>> getStudentById(@PathVariable Integer studentid) throws StudentNotFoundException {
		
		return ResponseEntity.ok(studentService.getStudentById(studentid));
		
	}
	
	
	@PutMapping("/update/{studentId}")
	public ResponseEntity<String> updateLeaves(@PathVariable Integer studentId ,@RequestBody Student student) throws Exception
	{
		 try{
			    
			   studentService.updateLeaves(studentId, student);
			   return ResponseEntity.ok("Student details updated");
			 }
			catch(Exception Exception ){
			  return new ResponseEntity(Exception.getMessage(), HttpStatus.CONFLICT);
			 }
		
				
	}

	@DeleteMapping("/student/deletebyId/{studentId}")
	public void deleteStudentById(@PathVariable Integer studentId) throws StudentNotFoundException 
	{
		studentService.deleteStudentById(studentId);
		
		//Integer deleteStudentId=studentService.deleteStudentById(studentId);
		//if(deleteStudentId!=null) {
			//return ResponseEntity.ok(deleteStudentId);
		//}else {
		  //    return (ResponseEntity<Integer>) ResponseEntity.status(HttpStatus.NOT_FOUND);
		  //}
			
			
	}
	
	
}
