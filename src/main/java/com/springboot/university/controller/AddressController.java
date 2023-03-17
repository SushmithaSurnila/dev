package com.springboot.university.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.university.entities.Address;
import com.springboot.university.service.AddressService;

@RestController
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	
	@GetMapping("/getalladdress")
	public List<Address> getallAddress()
	{
		return addressService.getAllAddress();
	}
	
	@PostMapping("/saveadddress")
	public void addAddress(@RequestBody Address address)
	{
		addressService.addAddress(address);
	}
	
	@PutMapping("/updateaddress")
	public void updateAddress(@RequestBody Address address)
	{
		addressService.updateAddress(address);
	}
	
	@DeleteMapping("/deleteaddress")
	public void deleteAddress(Address address)
	{
		addressService.deleteAddress(address);
	}

}
