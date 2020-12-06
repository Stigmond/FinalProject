package com.skilldistillery.bbqueggle.services;

import java.util.List;

import com.skilldistillery.bbqueggle.entities.Address;

public interface AddressService {

	List<Address>getAllAddresses();
	
	Address findById(int addId);
	
	Address create(Address address);
	
	Address update(Integer addId, Address address);
	
	boolean delete(Integer addId);
}
