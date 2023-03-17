package com.springboot.university.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.university.entities.Address;
import com.springboot.university.entities.Department;
import com.springboot.university.entities.Student;
import com.springboot.university.repository.StudentRepository;
import com.springboot.university.service.Studentservice;

import ch.qos.logback.core.net.ObjectWriter;


@WebMvcTest(StudentController.class)
class StudentControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private Studentservice studentService;
	
	 @Autowired
	private ObjectMapper mapper = new ObjectMapper();

	
	@Test
	void testgetAllStudents() throws Exception {
		List <Student> students=new ArrayList<>();
			
		Student student=new Student();
		student.setName("sushmitha");
		student.setGender("female");
		student.setStudentId(1);
	
			Address address = new Address();
			address.setAddressline1("Nehru Nagar");
			address.setAddressline2("Alwal");
			address.setCity("hyd");
			address.setCountry("India");
			address.setPincode(500010);
			student.setAddress(address);
			
				Department department = new Department();
				department.setDepId(123L);
				department.setDeptname("Mech");
		student.setDepartment(department);
		
		student.setPhonenumber(799583);
		student.setAvailableNumberOfLeaves(10);
		student.setLeaves(2);
		
		students.add(student);
		
		when(studentService.getAllStudent()).thenReturn(students);
		
		String json = mapper.writeValueAsString(student);
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/student")
				.content(json)
				.contentType(MediaType.APPLICATION_JSON);
		 MvcResult mvcResult=mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
		 String actualResponseBody = mvcResult.getResponse().getContentAsString();
		 JSONAssert.assertEquals("[{studentId:1}]", actualResponseBody, false);
		 
	}
	
	@Test
	public void testaddStudent() throws Exception
	{	
		Student s1=new Student();
		s1.setName("claty");
		s1.setGender("male");
		s1.setStudentId(2);
	
			Address a1 = new Address();
			a1.setAddressline1("gachibowli");
			a1.setAddressline2("KPHB");
			a1.setCity("hyd");
			a1.setCountry("India");
			a1.setPincode(500007);
			s1.setAddress(a1);
			
				Department d1 = new Department();
				d1.setDepId(517L);
				d1.setDeptname("CSE");
		s1.setDepartment(d1);
		
		s1.setPhonenumber(910087);
		s1.setAvailableNumberOfLeaves(10);
		s1.setLeaves(3);
		
		
		when(studentService.addStudent(Mockito.any(Student.class))).thenReturn(s1);
		String json = mapper.writeValueAsString(s1);
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/save")
				.content(json)
				.contentType(MediaType.APPLICATION_JSON);
		
		 MvcResult mvcResult=mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
			String actualResponseBody = mvcResult.getResponse().getContentAsString();
			String expected="Student details saved";
			assertThat(actualResponseBody).isEqualToIgnoringWhitespace(expected);
			

	    
	}
	
    @Test
	public void testupdateStudent() throws Exception
	{
		Student s1=new Student();
		s1.setName("divya");
		s1.setGender("female");
		s1.setStudentId(3);
	
			Address a1 = new Address();
			a1.setAddressline1("Miyapur");
			a1.setAddressline2("SR Nagar");
			a1.setCity("hyd");
			a1.setCountry("India");
			a1.setPincode(500008);
			s1.setAddress(a1);
			
				Department d1 = new Department();
				d1.setDepId(508L);
				d1.setDeptname("ECE");
          s1.setDepartment(d1);
		
		s1.setPhonenumber(63034);
		s1.setAvailableNumberOfLeaves(10);
		s1.setLeaves(4);
		
		Mockito.when(studentService.updateStudent(Mockito.any(Student.class))).thenReturn(s1);
		String json = mapper.writeValueAsString(s1);
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.put("/update")
				.content(json)
				.contentType(MediaType.APPLICATION_JSON);

	    MvcResult mvcResult=mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
		String actualResponseBody = mvcResult.getResponse().getContentAsString();
		String expected="Student details Updated";
		assertThat(actualResponseBody).isEqualToIgnoringWhitespace(expected);
		
		
	}
	
	

	
}
