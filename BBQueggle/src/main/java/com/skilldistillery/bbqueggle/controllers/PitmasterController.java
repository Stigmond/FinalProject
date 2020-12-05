package com.skilldistillery.bbqueggle.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.bbqueggle.entities.Pitmaster;
import com.skilldistillery.bbqueggle.services.PitmasterServiceImpl;

@CrossOrigin({ "*", "http://localhost:4210" })  // NEED ALL THESE ANNOTATIONS FOR ALL CONTROLLERS
@RestController
@RequestMapping("api")

public class PitmasterController {

	@Autowired
	PitmasterServiceImpl PSI;
	
	@GetMapping("pitmaster")
	public List<Pitmaster> getAllPitmasters() {
		List<Pitmaster> pitmasters = new ArrayList<>();
		pitmasters = PSI.getAllPitmasters();
		return pitmasters;
	}
	
	@GetMapping("pitmaster/{id}")
	public Pitmaster getPitmasterById(@PathVariable Integer id, HttpServletResponse response) {
		Pitmaster result = PSI.getPitmasterById(id);
		if (result == null) {
			response.setStatus(404);
		}
		return result;
	}
}
