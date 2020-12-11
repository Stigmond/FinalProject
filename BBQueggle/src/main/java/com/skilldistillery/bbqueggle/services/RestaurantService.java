package com.skilldistillery.bbqueggle.services;

import java.util.List;

import com.skilldistillery.bbqueggle.entities.Restaurant;

public interface RestaurantService {

	List<Restaurant> index();

	Restaurant showRestaurant(Integer id);

	Restaurant createRestaurant(String username, Restaurant restaurant);

	Restaurant updateRestaurant(String username, Restaurant restaurant, Integer id);

	boolean deleteRestaurant(String username, Integer id);

	List<Restaurant> showRestaurantsByState(String state);
	
	List<Restaurant> showStateRestaurantsBySideDish(String state, String sideDish);
	
	List<Restaurant> showStateRestaurantsByName(String state, String name);
	
	List<Restaurant> showStateRestaurantsByMeatType(String state, String meatType);
	
	List<Restaurant> showStateRestaurantsByStyle(String state, Integer styleId);
}
