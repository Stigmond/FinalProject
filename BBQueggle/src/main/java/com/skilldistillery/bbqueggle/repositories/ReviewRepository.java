package com.skilldistillery.bbqueggle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.bbqueggle.entities.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer>{

}
