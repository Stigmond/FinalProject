package com.skilldistillery.bbqueggle.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		Pitmaster pitmaster = PSI.getPitmasterById(id);
		if (pitmaster == null) {
			response.setStatus(404);
		}
		return pitmaster;
	}
	
	@PostMapping("pitmaster")
	public Pitmaster addPitmaster(@RequestBody Pitmaster newPitmaster, HttpServletResponse response, HttpServletRequest request) {
		newPitmaster = PSI.createPitmaster(newPitmaster);
		StringBuffer strUrl = request.getRequestURL().append("/").append(newPitmaster.getId());
		String url = strUrl.toString();
		System.out.println(url);
		response.setHeader("Location", url);
		return newPitmaster;
	}
	
	@PutMapping("pitmaster/{id}")
	public Pitmaster updatePitmaster(@PathVariable Integer id, @RequestBody Pitmaster updatedPitmaster, HttpServletResponse response) {
		updatedPitmaster = PSI.updatePitmaster(id, updatedPitmaster);
		if (updatedPitmaster == null) {
			response.setStatus(404);
		}
		return updatedPitmaster;	
	}
	
	@DeleteMapping("pitmaster/{id}")
	public void deletePitmaster(@PathVariable Integer id, HttpServletResponse response) {
		boolean deleted = PSI.deletePitmaster(id);
		if (deleted == true) {
			response.setStatus(204);
		} else {
			response.setStatus(404);
		}
		
	}
	
}
