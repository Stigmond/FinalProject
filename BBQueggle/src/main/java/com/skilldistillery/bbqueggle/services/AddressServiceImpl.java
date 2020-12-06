package com.skilldistillery.bbqueggle.services;

import java.util.List;
import java.util.Optional;

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
	public Address create(Address address) {
			address = addRepo.saveAndFlush(address);
		return address;
	}

	@Override
	public Address update(Integer addId, Address address) {
		Optional<Address> addOpt = addRepo.findById(addId);
		Address manageAd = null;
		if (addOpt.isPresent()) {
			manageAd = addOpt.get();
			if (address.getStreet() != null) {
				manageAd.setStreet(address.getStreet());
			}
			if (address.getCity() != null) {
				manageAd.setCity(address.getCity());
			}
			if (address.getState() != null) {
				manageAd.setState(address.getState());
			}
			if (address.getZip() != null) {
				manageAd.setZip(address.getZip());
			}
			addRepo.flush();
		}
		return manageAd;
	}

	@Override
	public boolean delete(Integer addId) {
		boolean deleted = false;
		Optional<Address> addOpt = addRepo.findById(addId);
		if(addOpt.isPresent()) {
			addRepo.delete(addOpt.get());
		}
		return false;
	}

	
	



}
