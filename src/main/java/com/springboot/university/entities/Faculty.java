package com.springboot.university.entities;

import org.springframework.beans.factory.annotation.Value;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Faculty {
	
	private String name;
	
	private String gender;
	
	@Id
	private Long facultyid;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Department department;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
	private int leaves;
	
	
	
	public int getLeaves() {
		return leaves;
	}

	public void setLeaves(int leaves) {
		this.leaves = leaves;
	}

	private int availableNumberOfLeaves;
	
	private long phonenumber;

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

	public long getFacultyid() {
		return facultyid;
	}

	public void setFacultyid(long facultyid) {
		this.facultyid = facultyid;
	}

	public Department getDepartmentid() {
		return department;
	}

	public void setDepartmentid(Department department) {
		this.department = department;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getAvailableNumberOfLeaves() {
		return availableNumberOfLeaves;
	}

	public void setAvailableNumberOfLeaves(int availableNumberOfLeaves) {
		this.availableNumberOfLeaves = availableNumberOfLeaves;
	}

	public long getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(Long phonenumber) {
		this.phonenumber = phonenumber;
	}

	public Faculty(String name, String gender, Long facultyid, Department department, Address address, int leaves,
			int availableNumberOfLeaves, long phonenumber) {
		super();
		this.name = name;
		this.gender = gender;
		this.facultyid = facultyid;
		this.department = department;
		this.address = address;
		this.leaves = leaves;
		this.availableNumberOfLeaves = availableNumberOfLeaves;
		this.phonenumber = phonenumber;
	}

	public Faculty() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
