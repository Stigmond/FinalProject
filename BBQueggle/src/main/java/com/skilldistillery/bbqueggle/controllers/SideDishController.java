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

import com.skilldistillery.bbqueggle.entities.SideDish;
import com.skilldistillery.bbqueggle.services.SideDishServiceImpl;

@CrossOrigin({ "*", "http://localhost:4210" })  // NEED ALL THESE ANNOTATIONS FOR ALL CONTROLLERS
@RestController
@RequestMapping("api")
public class SideDishController {
	
	@Autowired
	SideDishServiceImpl sdSvc;
	
	@GetMapping("sidedish")
	public List<SideDish> getAll(){
		return sdSvc.getAllSideDishes();
	}
	
	@GetMapping("sidedish/{id}")
	public SideDish findById(@PathVariable int id) {
		return sdSvc.findById(id);
	}
	
	@PostMapping("sidedish")
	public SideDish create(@RequestBody SideDish sideDish, Principal principal) {
		sideDish = sdSvc.create(sideDish, principal.getName());
		return sideDish;
	}
	
	@PutMapping("sidedish/{id}")
	public SideDish update(@RequestBody SideDish sideDish, @PathVariable Integer id, Principal principal) {
		sideDish = sdSvc.update(id, sideDish, principal.getName());
		return sideDish;
	}
	@DeleteMapping("sidedish/{id}")
	public void delete(@PathVariable Integer id, Principal principal) {
		boolean deleted = sdSvc.delete(id, principal.getName());
		
	}

}
