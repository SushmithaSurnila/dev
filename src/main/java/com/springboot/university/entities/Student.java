package com.springboot.university.entities;

import java.util.function.IntPredicate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Student")
public class Student {
	
	private String name;
	
	private String gender;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer studentId;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
	@OneToOne(cascade=CascadeType.ALL)

	private  Department department;
	
	private long phonenumber;

	private int availableNumberOfLeaves=10;
	
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

	public long getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(long phonenumber) {
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

	public Student(String name, String gender, Integer studentId, Address address, Department department, long phonenumber,
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
