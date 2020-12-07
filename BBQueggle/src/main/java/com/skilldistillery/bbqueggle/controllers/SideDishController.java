package com.skilldistillery.bbqueggle.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	
	public List<SideDish> getAll(){
		return sdSvc.getAllSideDishes();
	}

}
