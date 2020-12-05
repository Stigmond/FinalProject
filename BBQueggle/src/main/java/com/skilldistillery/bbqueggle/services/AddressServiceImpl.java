package com.skilldistillery.bbqueggle.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.bbqueggle.entities.Address;
import com.skilldistillery.bbqueggle.repositories.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addRepo;
	
	@Override
	public List<Address> getAllAddresses() {
		return addRepo.findAll();
	}
	
	@Override
	public Address findById(int addId) {
		return addRepo.findById(addId);
	}

	@Override
	public Address create(Address address, int addId) {
		address = addRepo.findById(addId);
		if(address!= null) {
			addRepo.saveAndFlush(address);
		}
		return address;
	}

	
	



}
