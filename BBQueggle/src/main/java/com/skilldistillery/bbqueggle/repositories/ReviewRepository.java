package com.skilldistillery.bbqueggle.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.bbqueggle.entities.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer>{

	List<Review> findByRestaurant_Id(Integer id);
}
