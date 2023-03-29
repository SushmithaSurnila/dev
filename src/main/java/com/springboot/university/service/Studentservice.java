package com.springboot.university.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Supplier;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.university.entities.Department;
import com.springboot.university.entities.Faculty;
import com.springboot.university.entities.Student;
import com.springboot.university.exception.FacultyNotFoundException;
import com.springboot.university.exception.StudentAlreadyExistsException;
//import com.springboot.university.exception.StudentInsufficientException;
import com.springboot.university.exception.StudentNotFoundException;
import com.springboot.university.repository.StudentRepository;

@Service
public class Studentservice {
	
	
	@Autowired
	private StudentRepository studentRepository;
		
	public List<Student> getAllStudent() throws StudentNotFoundException{
		List<Student> students=studentRepository.findAll();
		if(students.isEmpty()) {
			throw new StudentNotFoundException("No student found");
		}
		return students;
	    
	     
	   }

	public Student addStudent(Student student) throws StudentAlreadyExistsException  
	{
		if(studentRepository.existsById(student.getStudentId()))
			throw new StudentAlreadyExistsException("Student Already Exists");
		
	    Student saveStudent= studentRepository.save(student);
	    return saveStudent;
	}
	
	
	public Optional<Student> getStudentById(Integer studentId) throws StudentNotFoundException 
    {
		Optional<Student> student=studentRepository.findById(studentId);
		if(student.isPresent()){
			return student;
		}
		else{
			throw new StudentNotFoundException("student not found with id:");
		}
		  		   
	}

	public Student updateLeaves(Integer studentId,Student student) throws Exception
	{
		
		Student st=studentRepository.findById(student.getStudentId())
				.orElseThrow(()->new StudentNotFoundException("No student with id"));
		if(student.getName()!=null)		{
			st.setName(student.getName());
		}
		
		if(student.getLeaves()!=0)
		{
			if(student.getLeaves()<=st.getAvailableNumberOfLeaves())
			{
				student.setAvailableNumberOfLeaves(st.getAvailableNumberOfLeaves()-student.getLeaves());
				st.setLeaves(student.getAvailableNumberOfLeaves());
			}
			else
			{
				throw new Exception("Leaves cannot be granted due to insufficient leave balance");
			}
			
		}
		return studentRepository.save(student);
		
			
	}
	
	
	public void deleteStudentById(Integer studentId) throws StudentNotFoundException
	{
		Optional<Student> student=studentRepository.findById(studentId);
		if(student.isPresent()){
			studentRepository.deleteById(studentId);
		}
		else{
			throw new StudentNotFoundException("student with id "+ studentId +" not found");
		}
			
		    		  		
	}

	

	
}
