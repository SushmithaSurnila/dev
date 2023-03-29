package com.springboot.university.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

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
import com.springboot.university.exception.StudentAlreadyExistsException;
import com.springboot.university.exception.StudentNotFoundException;
import com.springboot.university.repository.StudentRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class StudentserviceTest {

	@Autowired
	private Studentservice studentService;

	@Autowired
	private StudentRepository studentRepository;

	@Test
	@Order(1)
	void testSave() throws StudentAlreadyExistsException {

		Address a = new Address();
		a.setCity("Hyderabad");
		a.setAddressline1("Alwal");
		a.setAddressline1("KPHB");
		a.setPincode(500010);
		a.setCountry("India");
		Department d = new Department();
		d.setDepId(523L);
		d.setDeptname("CSE");

		Student s = new Student();
		s.setName("sushmitha");
		s.setGender("female");
		s.setStudentId(1);
		s.setAddress(a);
		s.setDepartment(d);
		s.setPhonenumber("7995830188");
		s.setAvailableNumberOfLeaves(10);
		s.setLeaves(2);

		Student saveStudent = studentService.addStudent(s);

		assertThat(saveStudent).isNotNull();

		assertThat(saveStudent.getStudentId()).isGreaterThan(0);

	}

	@Test
	@Order(3)
	void testbyId() throws StudentNotFoundException {
		Optional<Student> s = studentService.getStudentById(1);
		assertThat(s.get()).isNotNull();
	}

	@Test
	@Order(2)
	void testfindall() throws StudentAlreadyExistsException, StudentNotFoundException {

		Student s = new Student();
		s.setName("sangeetha");
		s.setGender("female");
		s.setStudentId(3);

		Address a = new Address();
		a.setCity("Delhi");
		a.setAddressline1("Madhapur");
		a.setAddressline1("KPHB");
		a.setPincode(500010);
		a.setCountry("India");

		Department d = new Department();
		d.setDepId(521L);
		d.setDeptname("CIV");

		s.setPhonenumber("7995812188");
		s.setAvailableNumberOfLeaves(10);
		s.setLeaves(5);

		Student s1 = new Student();
		s1.setName("sushmitha");
		s1.setGender("female");
		s1.setStudentId(2);
		Address a1 = new Address();
		a1.setCity("Hyd");
		a1.setAddressline1("LB Nagar");
		a1.setAddressline1("SR Nagar");
		a1.setPincode(500007);
		a1.setCountry("India");
		Department d1 = new Department();
		d1.setDepId(523L);
		d1.setDeptname("ECE");
		s1.setPhonenumber("7995830987");
		s1.setAvailableNumberOfLeaves(10);
		s1.setLeaves(3);

		studentService.addStudent(s1);
		studentService.addStudent(s);

		java.util.List<Student> students = studentService.getAllStudent();
		Assertions.assertThat(students).isNotNull();

	}

	 @Test
	@Order(4)
	void testUpdate() throws Exception {

		Student student = new Student("priya", "female", 4, null, null, "7995830188", 7, 2);
		studentService.addStudent(student);
		student.setName("srivani");
		student.setPhonenumber("8764545123");
		//studentService.updateLeaves(1, student);

		Student updateStudent = studentService.updateLeaves(student.getStudentId(), student);

		Assertions.assertThat(updateStudent.getName()).isEqualTo("srivani");
		Assertions.assertThat(updateStudent.getPhonenumber()).isEqualTo("8764545123");

	}

	@Test
	@Order(5)
	void testdelete() throws StudentNotFoundException, StudentAlreadyExistsException {
		Student s = new Student();
		s.setName("manasa");
		s.setGender("female");
		s.setStudentId(5);
		Address a1 = new Address();
		a1.setCity("Hyd");
		a1.setAddressline1("SR Nagar");
		a1.setAddressline1("Madhura Nagar");
		a1.setPincode(500007);
		a1.setCountry("India");
		Department d1 = new Department();
		d1.setDepId(543L);
		d1.setDeptname("Mech");
		s.setAddress(a1);
		s.setDepartment(d1);
		s.setPhonenumber("7995830188");
		s.setAvailableNumberOfLeaves(10);
		s.setLeaves(2);

		studentService.addStudent(s);

		studentService.deleteStudentById(1);

		// Student deleteID =studentService.deleteStudentById(1);
		Assertions.assertThat(studentRepository.existsById(1)).isFalse();
	}

}
