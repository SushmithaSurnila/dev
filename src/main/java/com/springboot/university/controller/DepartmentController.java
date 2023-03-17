package com.springboot.university.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.university.entities.Department;
import com.springboot.university.service.DepartmentService;


@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/savedept")
	public void AddDepartment(@RequestBody Department department)
	{
		departmentService.addDepartment(department);
	}
	
	@PutMapping("/updatedept")
	public void UpdateDepartment(@RequestBody Department department)
	{
		departmentService.UpdateDepartment(department);
	}	
	@GetMapping("/findall")
	public ArrayList<Department> getAllDepartment() {
		return departmentService.findAllDepartment();
	}
	
	@GetMapping("/findbyid/{id}")
	public Department getDepartmentUsingId(@PathVariable Long depId) {
		return departmentService.findAllDepartmentByID(depId);
	}
	
	@DeleteMapping("/delete")
	public void delete(Department department) {
		departmentService.delete(department);
	}

}
