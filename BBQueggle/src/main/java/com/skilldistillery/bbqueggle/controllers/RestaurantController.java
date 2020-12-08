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

import com.skilldistillery.bbqueggle.entities.Restaurant;
import com.skilldistillery.bbqueggle.services.RestaurantServiceImpl;

@CrossOrigin({ "*", "http://localhost:4210" })
@RequestMapping("api")
@RestController
public class RestaurantController {

	@Autowired
	private RestaurantServiceImpl svc;

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

	// CRUD Methods

	@PostMapping("restaurants")
	public Restaurant createRestaurant(@RequestBody Restaurant restaurant, HttpServletResponse response,
			HttpServletRequest request) {
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

	@PutMapping("restaurants/{restaurantId}")
	public Restaurant updateRestaurant(@PathVariable Integer restaurantId, @RequestBody Restaurant restaurant,
			HttpServletResponse response) {
		try {
			restaurant = svc.updateRestaurant(restaurant, restaurantId);
			if (restaurant == null) {
				response.setStatus(404);
				restaurant = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(400);
			restaurant = null;
		}
		return restaurant;
	}

	@DeleteMapping("restaurants/{restaurantId}")
	public void deleteRestaurant(@PathVariable Integer restaurantId, HttpServletResponse response) {
		if (svc.deleteRestaurant(restaurantId)) {
			response.setStatus(204);

		} else {
			response.setStatus(404);
		}
	}
	
	// CUSTOM SEARCHES
	
	@GetMapping("restaurants/search/{state}")
	public List<Restaurant> findRestaurantsByState(@PathVariable String state, HttpServletResponse response) {
		List<Restaurant> result = new ArrayList<>();
		state = state.toUpperCase();
		result = svc.showRestaurantsByState(state);
		if (result.isEmpty()) {
			response.setStatus(404);
			return null;
		}
		return result;
	}
	
	@GetMapping("restaurants/search/{state}/{sideDishId}")
	public List<Restaurant> findRestaurantsBySideDish(@PathVariable String state, @PathVariable Integer sideDishId, HttpServletResponse response) {
		System.out.println("***** STATE: " + state);
		System.out.println("***** SIDE DISH: " + sideDishId);
		List<Restaurant> result = new ArrayList<>();
		state = state.toUpperCase();
		result = svc.showRestaurantsBySideDish(state, sideDishId);
		if (result.isEmpty()) {
			response.setStatus(404);
			return null;
		}
		return result;
	}
	
}
