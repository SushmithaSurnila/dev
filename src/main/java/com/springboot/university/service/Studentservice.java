package com.springboot.university.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Supplier;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.university.entities.Department;
import com.springboot.university.entities.Student;
import com.springboot.university.exception.StudentNotFoundException;
import com.springboot.university.repository.StudentRepository;

@Service
public class Studentservice {
	
	private static  int availableNumberOfLeaves;
	@Autowired
	private StudentRepository studentRepository;
		
	public List<Student> getAllStudent(){
	      List<Student> students = new ArrayList<Student>();
	      studentRepository.findAll().forEach(student -> students.add(student));
	      return students;
	   }

	public Student addStudent(Student student)  
	{    
	  return studentRepository.save(student);
	}
	
	
	public Student getStudentById(Integer studentId) {
	       return studentRepository.findById(studentId).get();
	}

	public void updateLeaves(Student student) throws StudentNotFoundException
	{
		
		Student st=studentRepository.findById(student.getStudentId())
				.orElseThrow(()->new StudentNotFoundException("No student with id"));
		if(student.getName()!=null)
		{
			st.setName(student.getName());
		}
		
		if(student.getLeaves()!=0)
		{
			if(student.getLeaves()<=st.getAvailableNumberOfLeaves())
			{
				student.setAvailableNumberOfLeaves(st.getLeaves()-student.getLeaves());
				st.setLeaves(student.getLeaves());
			}
		}
		studentRepository.save(st);
			
	}
	
	public Student updateStudent(Student student)
	{
		
		return studentRepository.save(student);
		
	}
	
	public Student deleteStudentById(Integer studentId)
	{
		
		studentRepository.deleteById(studentId);
		return null;
			
	}
	
}
