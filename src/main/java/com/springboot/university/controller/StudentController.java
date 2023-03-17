package com.springboot.university.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.university.entities.Department;
import com.springboot.university.entities.Student;
import com.springboot.university.exception.StudentNotFoundException;
import com.springboot.university.service.Studentservice;

@RestController
public class StudentController {
	
	@Autowired
	private Studentservice studentService;

	
	@GetMapping("/student")
	public List<Student> getAllStudents()  
	{    
	return studentService.getAllStudent();
	
	}	
	
	@PostMapping("/save")
	public String addStudent(@RequestBody Student student)
	{
		studentService.addStudent(student);
		return "Student details saved";
			
	}
	
	
	@GetMapping("student/findbyId/{studentid}")
	public ResponseEntity<Student> getStudentById(@PathVariable Integer studentid) {
		Student student= studentService.getStudentById(studentid);
		if(student == null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(student));
		
	}
	
	
	@PutMapping("/update")
	public String updateStudent(@RequestBody Student student)
	{
		studentService.updateStudent(student);
		return "Student details Updated";
		
				
	}
	
	@PutMapping("/update/leaves")
	public void updateLeaves(Student student) throws StudentNotFoundException
	{
		studentService.updateLeaves(student);
		
				
	}

	@DeleteMapping("/student/deletebyId/{studentId}")
	public String deleteStudentById(@PathVariable Integer studentId)
	{
		studentService.deleteStudentById(studentId);
		return "Student with Id deleted";
		
	}
	
	
}
