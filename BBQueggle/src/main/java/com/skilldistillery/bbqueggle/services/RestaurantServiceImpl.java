package com.skilldistillery.bbqueggle.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.bbqueggle.entities.Restaurant;
import com.skilldistillery.bbqueggle.repositories.RestaurantRepository;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RestaurantRepository repo;

	@Override
	public List<Restaurant> index() {
		List<Restaurant> allRestaurants = repo.findAll();
		return allRestaurants;
	}

	@Override
	public Restaurant showRestaurant(Integer id) {
		Optional<Restaurant> restaurantOpt = repo.findById(id);
		Restaurant restaurant = null;
		if (restaurantOpt.isPresent()) {
			restaurant = restaurantOpt.get();
		}
		return restaurant;
	}

	@Override
	public Restaurant createRestaurant(Restaurant restaurant) {
		repo.saveAndFlush(restaurant);
		return repo.save(restaurant);
	}

	@Override
	public Restaurant updateRestaurant(Restaurant restaurant, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteRestaurant(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

}
