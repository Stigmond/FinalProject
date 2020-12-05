package com.skilldistillery.bbqueggle.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.skilldistillery.bbqueggle.entities.Address;
import com.skilldistillery.bbqueggle.repositories.AddressRepository;

public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addRepo;
	
	@Override
	public List<Address> findAll() {
		return addRepo.findAll();
	}
	
	@Override
	public Address findById(int addId) {
		return addRepo.findById(addId);
	}

	@Override
	public Address create(String name, int addId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	



}
