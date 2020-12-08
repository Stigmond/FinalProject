package com.skilldistillery.bbqueggle.rankers;

import java.util.List;

import com.skilldistillery.bbqueggle.entities.Restaurant;

public interface RestaurantRanker {


	List<Restaurant> rankRestaurants(List<Restaurant> restaurants);
}
