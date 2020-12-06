package com.skilldistillery.bbqueggle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.bbqueggle.entities.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

}
