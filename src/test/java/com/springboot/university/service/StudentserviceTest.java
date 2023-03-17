package com.springboot.university.service;

import static org.assertj.core.api.Assertions.assertThat;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.university.entities.Address;
import com.springboot.university.entities.Department;
import com.springboot.university.entities.Student;


@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class StudentserviceTest {
	
	@Autowired
	private Studentservice studentService;
	
	
	@Test
	@Order(1)
	void testSave() {
		
		Address a=new Address();
		a.setCity("Hyderabad");
		a.setAddressline1("Alwal");
		a.setAddressline1("KPHB");
		a.setPincode(500010);
		a.setCountry("India");
		Department d=new Department();
		d.setDepId(523L);
		d.setDeptname("CSE");
		
		Student s = new Student();
	      s.setName("sushmitha");
			s.setGender("female");
			s.setStudentId(1);
			s.setAddress(a);	
			s.setDepartment(d);
			s.setPhonenumber(799583);
			s.setAvailableNumberOfLeaves(10);
			s.setLeaves(2);
			
	      Student saveStudent=studentService.addStudent(s);
	      
	      assertThat(saveStudent).isNotNull();
	      
	      assertThat(saveStudent.getStudentId()).isGreaterThan(0);
		
	}
	 @Test
	 @Order(3)
	 void testbyId()
	 {
			Student s= studentService.getStudentById(1);		
			assertThat(s.getStudentId()).isNotNull();		 
	 }
	 
	 @Test
	 @Order(2)
	 void testfindall()
	 {
		 Student s=new Student();
		 Student s1 = new Student();
	      s1.setName("divya");
			s1.setGender("female");
			s1.setStudentId(1);
			s1.setAddress(null);
			s1.setDepartment(null);
			s1.setPhonenumber(799583);
			s1.setAvailableNumberOfLeaves(10);
			s1.setLeaves(2);
			
			studentService.addStudent(s1);
			studentService.addStudent(s);
			
		    java.util.List<Student> students=studentService.getAllStudent();
			Assertions.assertThat(students.size()).isGreaterThan(0);

			
		 
	}
	 
	 @Test
	 @Order(4)
	 void testUpdate()
	 {
		 Student s=studentService.getStudentById(1);
		 s.setName("sangeetha");
		 s.setPhonenumber(8764545);
		 Student studentUpdated=studentService.addStudent(s);
		 
		 Assertions.assertThat(studentUpdated.getName()).isEqualTo("sangeetha");
		 Assertions.assertThat(studentUpdated.getPhonenumber()).isEqualTo(8764545);
		 
	 }
	 
	 @Test
	 @Order(5)
	 void testdelete()
		{
		 Student s = new Student();
	      s.setName("sushmitha");
			s.setGender("female");
			s.setStudentId(1);   
			s.setAddress(null);
			s.setDepartment(null);
			s.setPhonenumber(799583);
			s.setAvailableNumberOfLeaves(10);
			s.setLeaves(2);
			
	        studentService.addStudent(s);
	      
			Student deleteID =studentService.deleteStudentById(s.getStudentId());		
			Assertions.assertThat(deleteID).isNull();	 		
	 }
	 
	 

}
