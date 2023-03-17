package com.springboot.university.repository;

import org.springframework.data.repository.CrudRepository;

import com.springboot.university.entities.Address;

public interface AddressRepository extends CrudRepository<Address,String>{

}
