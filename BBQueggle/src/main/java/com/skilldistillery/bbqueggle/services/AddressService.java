package com.skilldistillery.bbqueggle.services;

import java.util.List;

import com.skilldistillery.bbqueggle.entities.Address;

public interface AddressService {

	List<Address>findAll();
	
	Address findById(int addId);
	
	Address create(String name, int addId);
}
