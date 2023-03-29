package com.springboot.university.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.university.entities.Student;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class StudentRepositoryTest2 {

	@Autowired
	private StudentRepository studentRepository;
	
	   @Test
	   @Order(1)
	   void testSave() {
	      Student s = new Student();
	     
			
			s.setName("sushmitha");
			s.setGender("female");
			s.setStudentId(1);
			s.setAddress(null);
			s.setDepartment(null);
			s.setPhonenumber("7995830188");
			s.setAvailableNumberOfLeaves(10);
			s.setLeaves(2);
			
	      Student saveStudent=studentRepository.save(s);
	      
	      assertThat(saveStudent).isNotNull();
	     // assertThat(saveStudent.getStudentId()).isGreaterThan(0);
	          
	   }
	   
	   @Test
	   @Order(2)
	   void testStudentAll()
	   {
		   Student s=new Student();
		   s.setName("sushmitha");
			s.setGender("female");
			s.setStudentId(1);
			s.setAddress(null);
			s.setDepartment(null);
			s.setPhonenumber("1234567892");
			s.setAvailableNumberOfLeaves(10);
			s.setLeaves(2);
		   
		   studentRepository.save(s);
		   
		   List<Student> students=studentRepository.findAll();
		   
		   Assertions.assertThat(students.size()).isGreaterThan(0);
		   
		   
	   }
	   @Test
	   @Order(3)
	   void testStudentId()
	   {
		   Student s=new Student();

		  
		   s.setName("sushmitha");
			s.setGender("female");
			s.setStudentId(1);
			
			s.setPhonenumber("9876543212");
			s.setAvailableNumberOfLeaves(10);
			s.setLeaves(2);
		   
		   studentRepository.save(s);
		   
		   assertThat(studentRepository.findById(1).get()).isNotNull();
		  
		   
	   }

		 @Test
		 @Order(4)
		 void testUpdate()
		 {
			 Student s=new Student();
			   s.setName("sushmitha");
				s.setGender("female");
				s.setStudentId(1);
				s.setAddress(null);
				s.setDepartment(null);
				s.setPhonenumber("9100875503");
				s.setAvailableNumberOfLeaves(10);
				s.setLeaves(2);
			   
			   studentRepository.save(s);
			
				 
			 Student studentUpdate=studentRepository.findById(1).get();
			 studentUpdate.setName("sangeetha");
			 studentUpdate.setPhonenumber("8976543219");
			 Student studentUpdated=studentRepository.save(studentUpdate);
			 
			 Assertions.assertThat(studentUpdated.getName()).isEqualTo("sangeetha");
			 Assertions.assertThat(studentUpdated.getPhonenumber()).isEqualTo("8976543219");
			 
		 }
		 
		 @Test
		 @Order(5)
		 void testdeleteID()
		 {		 
			 studentRepository.deleteById(1);
			 assertThat(studentRepository.existsById(1)).isFalse();
			 
			
		 }
		
}
