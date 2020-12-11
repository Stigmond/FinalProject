package com.skilldistillery.bbqueggle.controllers;

import java.security.Principal;
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
import com.skilldistillery.bbqueggle.rankers.RestaurantRankerImpl;
import com.skilldistillery.bbqueggle.services.RestaurantServiceImpl;

@CrossOrigin({ "*", "http://localhost:4210" })
@RequestMapping("api")
@RestController
public class RestaurantController {

	@Autowired
	private RestaurantServiceImpl svc;
	
	RestaurantRankerImpl restRank = new RestaurantRankerImpl();
	

	@GetMapping("restaurants")
	public List<Restaurant> allRestaurants() {
	List<Restaurant> restaurants = svc.index();
	return restRank.rankRestaurants(restaurants);
//	return svc.index();
	}

	@GetMapping("restaurants/{restaurantId}")
	public Restaurant showRestaurant(@PathVariable Integer restaurantId, Principal principal, HttpServletResponse response) {
		Restaurant restaurant = svc.showRestaurant(restaurantId);
		if (restaurant == null) {
			response.setStatus(404);
		}
		return restaurant;
	}

	// CRUD Methods

	@PostMapping("restaurants")
	public Restaurant createRestaurant(@RequestBody Restaurant restaurant, HttpServletResponse response,
			HttpServletRequest request, Principal principal) {
		Restaurant createdRestaurant = null;
		try {
			createdRestaurant = svc.createRestaurant(principal.getName(),restaurant);
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
			HttpServletResponse response, Principal principal) {
		try {
			restaurant = svc.updateRestaurant(principal.getName(), restaurant, restaurantId);
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
	public void deleteRestaurant(@PathVariable Integer restaurantId, HttpServletResponse response, Principal principal) {
		if (svc.deleteRestaurant(principal.getName(),restaurantId)) {
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
			return result;
		}
		
		for (int i = 0; i < result.size(); i++) {
			System.out.println(restRank.getScore(result.get(i)));
		}
		return restRank.rankRestaurants(result);
	}
	
	@GetMapping("restaurants/search/{state}/name/{name}")
	public List<Restaurant> findRestaurantsByName(@PathVariable String state, @PathVariable String name, HttpServletResponse response) {
		List<Restaurant> result = new ArrayList<>();
		state = state.toUpperCase();
		result = svc.showStateRestaurantsByName(state, name);
		if (result.isEmpty()) {
			response.setStatus(404);
			return null;
		}
		return result;
	}
	
	@GetMapping("restaurants/search/{state}/meat/{meatType}")
	public List<Restaurant> findRestaurantsByMeatType(@PathVariable String state, @PathVariable String meatType, HttpServletResponse response) {
		List<Restaurant> result = new ArrayList<>();
		state = state.toUpperCase();
		result = svc.showStateRestaurantsByMeatType(state, meatType);
		if (result.isEmpty()) {
			response.setStatus(404);
			return null;
		}
		return restRank.rankRestaurants(result);
	}
	

	@GetMapping("restaurants/search/{state}/sideDish/{sideDish}")
	public List<Restaurant> findRestaurantsBySideDish(@PathVariable String state, @PathVariable String sideDish, HttpServletResponse response) {
		List<Restaurant> result = new ArrayList<>();
		state = state.toUpperCase();
		result = svc.showStateRestaurantsBySideDish(state, sideDish);
		if (result.isEmpty()) {
			return result;
		}
		return restRank.rankRestaurants(result);
	}
	
	@GetMapping("restaurants/search/{state}/style/{style}")
	public List<Restaurant> findRestaurantsByStyle(@PathVariable String state, @PathVariable Integer style, HttpServletResponse response) {
		List<Restaurant> result = new ArrayList<>();
		state = state.toUpperCase();
		result = svc.showStateRestaurantsByStyle(state, style);
		if (result.isEmpty()) {
			response.setStatus(404);
			return null;
		}
		return restRank.rankRestaurants(result);
	}
	
}
