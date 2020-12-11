package com.skilldistillery.bbqueggle.services;

import java.util.List;

import com.skilldistillery.bbqueggle.entities.Address;

public interface AddressService {

	List<Address>getAllAddresses();
	
	Address findById(int addId);
	
	Address create(Address address, String username);
	
	Address update(Integer addId, Address address, String username);
	
	boolean delete(Integer addId, String username);
}
