package com.skilldistillery.bbqueggle.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.bbqueggle.entities.Restaurant;
import com.skilldistillery.bbqueggle.services.RestaurantService;

@CrossOrigin({ "*", "http://localhost:4210" })
@RequestMapping("api")
@RestController
public class RestaurantController {

	@Autowired
	private RestaurantService svc;

	@GetMapping("restaurants")
	public List<Restaurant> allRestaurants() {
		return svc.index();
	}

	@GetMapping("restaurants/{restaurantId}")
	public Restaurant showRestaurant(@PathVariable Integer restaurantId, HttpServletResponse response) {
		Restaurant restaurant = svc.showRestaurant(restaurantId);
		if (restaurant == null) {
			response.setStatus(404);
		}
		return restaurant;
	}
	
	//CRUD Methods
	
	@PostMapping("restaurants")
	public Restaurant createRestaurant(@RequestBody Restaurant restaurant, HttpServletResponse response, HttpServletRequest request) {
		Restaurant createdRestaurant = null;
		try {
			createdRestaurant = svc.createRestaurant(restaurant);
			response.setStatus(201);
			StringBuffer url = request.getRequestURL();
			url.append("/").append(restaurant.getId());
			response.setHeader("Location", url.toString());

		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(400);
			restaurant = null;
		}
		return createdRestaurant;
	}

}
