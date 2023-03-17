package com.springboot.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.university.entities.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty,Long>{

	
	

}
