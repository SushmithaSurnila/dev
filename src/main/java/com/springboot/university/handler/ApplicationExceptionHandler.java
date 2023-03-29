package com.springboot.university.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.springboot.university.exception.DepartmentNotFoundException;
import com.springboot.university.exception.FacultyNotFoundException;
import com.springboot.university.exception.StudentAlreadyExistsException;
import com.springboot.university.exception.StudentNotFoundException;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map<String,String> handleMethodArgumentException(MethodArgumentNotValidException exception)
	{
		Map<String,String> errorMap=new HashMap<>();
		exception.getBindingResult().getFieldErrors().forEach(error ->{
			errorMap.put(error.getField(), error.getDefaultMessage());
		}
		);
		
		return errorMap;
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(StudentAlreadyExistsException.class)
	public Map<String,String> handleBussinessException(StudentAlreadyExistsException ex)
	{
		Map<String,String> errorMap=new HashMap<>();
		errorMap.put("errorMessage", ex.getMessage());
		return errorMap;
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(StudentNotFoundException.class)
	public Map<String,String> handleBussinessException1(StudentNotFoundException exp)
	{
		Map<String,String> errorMap=new HashMap<>();
		errorMap.put("errorMessage", exp.getMessage());
		return errorMap;
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(FacultyNotFoundException.class)
	public Map<String,String> handleBussinessException2(FacultyNotFoundException exp1)
	{
		Map<String,String> errorMap=new HashMap<>();
		errorMap.put("errorMessage", exp1.getMessage());
		return errorMap;
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(DepartmentNotFoundException.class)
	public Map<String,String> handleBussinessException3(DepartmentNotFoundException exp1)
	{
		Map<String,String> errorMap=new HashMap<>();
		errorMap.put("errorMessage", exp1.getMessage());
		return errorMap;
	}


}
