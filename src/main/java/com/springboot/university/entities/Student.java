package com.springboot.university.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="Student")
public class Student {
	
	@NotBlank(message="student name shouldn't be blank or null")
	private String name;
	
	private String gender;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer studentId;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_addressline1",referencedColumnName = "addressline1")
	private Address address;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "fk_depId",referencedColumnName = "depId")
	private  Department department;
	
   
    @NotBlank(message="phone number shouldn't be blank or null")
    @Size(min=10,max=10,message="invalid phone number")
	private String phonenumber;
    
	private int availableNumberOfLeaves=7;
	
	private int leaves;	

	public int getLeaves() {
		return leaves;
	}

	public void setLeaves(int leaves) {
		this.leaves = leaves;
	}

	public int getAvailableNumberOfLeaves() {
		return availableNumberOfLeaves;
	}

	public void setAvailableNumberOfLeaves(int availableNumberOfLeaves) {
		this.availableNumberOfLeaves = availableNumberOfLeaves;
	}
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Student(String name, String gender, Integer studentId, Address address, Department department, String phonenumber,
			int availableNumberOfLeaves, int leaves) {
		super();
		this.name = name;
		this.gender = gender;
		this.studentId = studentId;
		this.address = address;
		this.department = department;
		this.phonenumber = phonenumber;
		this.availableNumberOfLeaves = availableNumberOfLeaves;
		this.leaves = leaves;
	}


	

	
	
}
