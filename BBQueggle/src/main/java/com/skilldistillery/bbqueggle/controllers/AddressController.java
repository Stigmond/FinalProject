package com.skilldistillery.bbqueggle.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public List<Address> getAllAddresses(Principal principal){
		return addSvc.getAllAddresses(principal.getName());
	}
	
	@GetMapping("address/{addId}")
	public Address findById(@PathVariable int addId, Principal principal) {
		return addSvc.findById(addId, principal.getName());
	}
	
	@PostMapping("address")
	public Address create(@RequestBody Address address, Principal principal) {
		address = addSvc.create(address, principal.getName());
		return address;
	}
	@PutMapping("address/{addId}")
	public Address update(@RequestBody Address address, @PathVariable Integer addId, Principal principal) {
		address = addSvc.update(addId, address, principal.getName());
		return address;
	}
	
	@DeleteMapping("address/{addId}")
	public void delete(@PathVariable Integer addId, Principal principal) {
		boolean deleted = addSvc.delete(addId, principal.getName());
		
	}

}
