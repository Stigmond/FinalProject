package com.skilldistillery.bbqueggle.services;

import java.util.ArrayList;
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
	public Restaurant createRestaurant(String username, Restaurant restaurant) {
		System.out.println(restaurant);
		repo.saveAndFlush(restaurant);
		return repo.save(restaurant);
	}

	@Override
	public Restaurant updateRestaurant(String username, Restaurant restaurant, Integer id) {
		Optional<Restaurant> restaurantOpt = repo.findById(id);
		Restaurant managedRestaurant = null;
		if (restaurantOpt.isPresent()) {
			managedRestaurant = restaurantOpt.get();

			if (restaurant.getName() != null) {
				managedRestaurant.setName(restaurant.getName());
			}
			if (restaurant.getPhoneNumber() != null) {
				managedRestaurant.setPhoneNumber(restaurant.getPhoneNumber());
			}
			if (restaurant.getDescription() != null) {
				managedRestaurant.setDescription(restaurant.getDescription());
			}
			if (restaurant.getWebsite() != null) {
				managedRestaurant.setWebsite(restaurant.getWebsite());
			}
			if (restaurant.getLogo() != null) {
				managedRestaurant.setLogo(restaurant.getLogo());
			}
			if (restaurant.getDineIn() != null) {
				managedRestaurant.setDineIn(restaurant.getDineIn());
			}
			if (restaurant.getHours() != null) {
				managedRestaurant.setHours(restaurant.getHours());
			}
			repo.flush();
		}
		return managedRestaurant;
	}

	public boolean deleteRestaurant(String username, Integer id) {
		boolean deleted = false;
		Optional<Restaurant> restaurantOpt = repo.findById(id);
		if (restaurantOpt.isPresent()) {
			repo.deleteById(id);
			deleted = true;
		}
		return deleted;
	}
	
	// SEARCH FUNCTIONS
	
	public List<Restaurant> showRestaurantsByState(String state) {
		List<Restaurant> result = new ArrayList<>();
		result = repo.findByAddress_State(state);
		return result;
	}

	public List<Restaurant> showStateRestaurantsBySideDish(String state, String sideDish) {
		List<Restaurant> result = new ArrayList<>();
		sideDish = "%" + sideDish + "%";
		result = repo.queryByStateAndSideDish(state, sideDish, sideDish);
		return result;
	}
	
	public List<Restaurant> showStateRestaurantsByName(String state, String name) {
		List<Restaurant> result = new ArrayList<>();
		name = "%" + name + "%";
		result = repo.findByAddress_StateAndNameLike(state, name);
		return result;
	}
	
	public List<Restaurant> showStateRestaurantsByMeatType(String state, String meatType) {
		List<Restaurant> result = new ArrayList<>();
		result = repo.findByAddress_StateAndMainDishes_MeatType(state, meatType);
		return result;
		
	}
	
	public List<Restaurant> showStateRestaurantsByStyle(String state, Integer styleId) {
		List<Restaurant> result = new ArrayList<>();
		result = repo.findByAddress_StateAndStyle_Id(state, styleId);
		return result;
	}

}
