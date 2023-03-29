package com.springboot.university.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
public class Department {
	
	@Id
	private Long depId;
	
	private String deptname;

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(Long depId, String deptname) {
		super();
		this.depId = depId;
		this.deptname = deptname;
	}

	public Long getDepId() {
		return depId;
	}

	public void setDepId(Long depId) {
		this.depId = depId;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	
	
	
}