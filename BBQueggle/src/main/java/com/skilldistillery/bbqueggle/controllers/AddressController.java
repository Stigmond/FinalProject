package com.skilldistillery.bbqueggle.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.bbqueggle.entities.Address;
import com.skilldistillery.bbqueggle.services.AddressServiceImpl;

@CrossOrigin({ "*", "http://localhost:4210" })  // NEED ALL THESE ANNOTATIONS FOR ALL CONTROLLERS
@RestController
@RequestMapping("api")
public class AddressController {
	
	@Autowired
	AddressServiceImpl addSvc;
	
	@GetMapping("address")
	public List<Address> getAllAddresses(){
		return addSvc.getAllAddresses();
	}
	
	@GetMapping("address/{addId}")
	public Address findById(@PathVariable int addId) {
		return addSvc.findById(addId);
	}
	
	@PostMapping("address")
	public Address create(@RequestBody Address address, @PathVariable int addId) {
		address = addSvc.create(address, addId);
		return address;
	}

}
