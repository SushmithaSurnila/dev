package com.springboot.university.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.university.entities.Address;
import com.springboot.university.entities.Faculty;
import com.springboot.university.repository.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepository addressRepository;
	
	public List<Address> getAllAddress()  
	{
	List<Address> address = new ArrayList<>();    
	addressRepository.findAll().forEach(address::add);    
	return address;    
	} 
	
	public void addAddress(Address address)  
	{    
	addressRepository.save(address);    
	}
	
	public void updateAddress(Address address)  
	{    
	addressRepository.save(address);    
	}
	
	public void deleteAddress(Address address)  
	{    
	addressRepository.delete(address);    
	}

}
