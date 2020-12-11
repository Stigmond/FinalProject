package com.skilldistillery.bbqueggle.controllers;

import java.security.Principal;
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

import com.skilldistillery.bbqueggle.entities.MainDish;
import com.skilldistillery.bbqueggle.services.MainDishServiceImpl;

@CrossOrigin({ "*", "http://localhost:4210" })
@RequestMapping("api")
@RestController
public class MainDishController {

	@Autowired
	private MainDishServiceImpl svc;

	@GetMapping("mainDish")
	public List<MainDish> index() {
		return svc.index();
	}

	@GetMapping("mainDish/{mainDishId}")
	public MainDish getMainDishById(@PathVariable Integer mainDishId, HttpServletResponse response) {
		MainDish mainDish = svc.getMainDishById(mainDishId);
		if (mainDish == null) {
			response.setStatus(404);
		}
		return mainDish;
	}

	@PostMapping("mainDish")
	public MainDish createMainDish(@RequestBody MainDish newMainDish, HttpServletResponse response,
			HttpServletRequest request, Principal principal) {
		MainDish createdMainDish = null;
		try {
			createdMainDish = svc.createMainDish(newMainDish, principal.getName());
			response.setStatus(201);
			StringBuffer url = request.getRequestURL();
			url.append("/").append(newMainDish.getId());
			response.setHeader("Location", url.toString());

		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(400);
			newMainDish = null;
		}
		return createdMainDish;

	}

	@PutMapping("mainDish/{mainDishId}")
	public MainDish updateMainDish(@PathVariable Integer mainDishId, @RequestBody MainDish updatedMainDish,
			HttpServletResponse response, Principal principal) {
		try {
			updatedMainDish = svc.updateMainDish(mainDishId, updatedMainDish, principal.getName());
			if (updatedMainDish == null) {
				response.setStatus(404);
				updatedMainDish = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(400);
			updatedMainDish = null;
		}
		return updatedMainDish;
	}

	@DeleteMapping("mainDish/{mainDishId}")
	public void deleteMainDish(@PathVariable Integer mainDishId, HttpServletResponse response, Principal principal) {
		if (svc.deleteMainDish(mainDishId, principal.getName())) {
			response.setStatus(204);

		} else {
			response.setStatus(404);
		}
	}

}
