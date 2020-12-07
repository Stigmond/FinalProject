package com.skilldistillery.bbqueggle.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@GetMapping("mainDishes")
	public List<MainDish> index() {
		return svc.index();
	}

	@GetMapping("mainDishes/{mainDishId}")
	public MainDish getMainDishById(@PathVariable Integer mainDishId, HttpServletResponse response) {
		MainDish mainDish = svc.getMainDishById(mainDishId);
		if (mainDish == null) {
			response.setStatus(404);
		}
		return mainDish;
	}

}
