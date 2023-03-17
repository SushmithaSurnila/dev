package com.springboot.university.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Address {
	
	private String city;
	
	@Id
	private String addressline1;
	
	private String addressline2;
	
	private String country;
	
	private long pincode;
	

	public Address(String city, String addressline1, String addressline2, String country, long pincode) {
		super();
		this.city = city;
		this.addressline1 = addressline1;
		this.addressline2 = addressline2;
		this.country = country;
		this.pincode = pincode;
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddressline1() {
		return addressline1;
	}

	public void setAddressline1(String addressline1) {
		this.addressline1 = addressline1;
	}

	public String getAddressline2() {
		return addressline2;
	}

	public void setAddressline2(String addressline2) {
		this.addressline2 = addressline2;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}
	

	
	

}
