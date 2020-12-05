package com.skilldistillery.bbqueggle.services;

import java.util.List;

import com.skilldistillery.bbqueggle.entities.Restaurant;

public interface RestaurantService {
	
	List<Restaurant> index();
	Restaurant showRestaurant(Integer id);
	Restaurant createRestaurant(Restaurant restaurant);
	Restaurant updateRestaurant(Restaurant restaurant, Integer id);
	boolean deleteRestaurant(Integer id);
	

}
