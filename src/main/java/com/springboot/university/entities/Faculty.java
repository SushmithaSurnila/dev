package com.springboot.university.entities;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Faculty {
	
	@NotBlank(message="faculty name shouldn't be blank or null")
	private String name;
	
	private String gender;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long facultyId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_depId",referencedColumnName = "depId")
	private Department department;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
	private int leaves;
	
	private int availableNumberOfLeaves=10;
	
	@NotBlank(message="phone number shouldn't be blank or null")
    @Size(min=10,max=10,message="invalid phone number")
	private String phonenumber;
	
	public Faculty(String name, String gender, Long facultyId, Department department, Address address, int leaves,
			int availableNumberOfLeaves, String phonenumber) {
		super();
		this.name = name;
		this.gender = gender;
		this.facultyId = facultyId;
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

	public Long getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(Long facultyId) {
		this.facultyId = facultyId;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

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

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	

	
}
