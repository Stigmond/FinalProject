package com.skilldistillery.bbqueggle.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.bbqueggle.entities.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

	List<Restaurant> findByAddress_State(String state);
	
	List<Restaurant> findByAddress_StateAndSideDish_Name(String state, String sideDish);
}
