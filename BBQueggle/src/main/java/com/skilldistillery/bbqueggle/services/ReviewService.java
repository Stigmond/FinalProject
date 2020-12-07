package com.skilldistillery.bbqueggle.services;

import java.util.List;

import com.skilldistillery.bbqueggle.entities.Review;

public interface ReviewService {

	List<Review> getAllReviewsByRestaurantId(Integer RestaurantId);
	
//	Review getRestaurantReviewByReviewId(Integer RestaurantId, Integer ReviewId);
	
	Review getReviewByReviewId(Integer ReviewId);
	
	Review createRestaurantReview(Review review);
	
	Review updateRestaurantReview(Integer RestaurantId, Integer ReviewId, Review review);
	
	boolean deleteRestaurantReview(Integer ReviewId);
}
