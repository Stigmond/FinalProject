package com.skilldistillery.bbqueggle.services;

import java.util.List;

import com.skilldistillery.bbqueggle.entities.Review;

public interface ReviewService {

	List<Review> getAllReviewsByRestaurantId(Integer restaurantId);
	
	public Review getReviewByReviewId(Integer restaurantId, Integer reviewId);
	
	Review createRestaurantReview(Review review);
	
	Review updateRestaurantReview(Integer restaurantId, Integer reviewId, Review review);
	
//	boolean deleteRestaurantReview(Integer restaurantId, Integer reviewId);
}
