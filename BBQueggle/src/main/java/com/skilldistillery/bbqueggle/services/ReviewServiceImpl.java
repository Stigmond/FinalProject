package com.skilldistillery.bbqueggle.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.bbqueggle.entities.Restaurant;
import com.skilldistillery.bbqueggle.entities.Review;
import com.skilldistillery.bbqueggle.repositories.ReviewRepository;

@Service
public class ReviewServiceImpl implements ReviewService{

	@Autowired
	ReviewRepository reviewRepo;
	RestaurantService restServ;
	
	@Override
	public List<Review> getAllReviewsByRestaurantId(Integer restaurantId) {
		List<Review> reviews = new ArrayList<>();
		reviews = reviewRepo.findByRestaurant_Id(restaurantId);
		return reviews;
	}

	@Override
	public Review getRestaurantReviewByReviewId(Integer restaurantId, Integer reviewId) {
		Review review = reviewRepo.findByIdAndRestaurant_Id(reviewId, restaurantId);
		return review;
	}

	@Override
	public Review createRestaurantReview(Review review, Integer restId) {
		Restaurant restaurant = new Restaurant();
		restaurant = restServ.showRestaurant(restId);
		review.setRestaurant(restaurant);
		review.setReviewDate(LocalDate.now());
		if (review.getReview() == null || review.getReview().equals("")) {
			review.setReview("No comment available");
		}
		review = reviewRepo.saveAndFlush(review);
		return review;
	}

	@Override
	public Review updateRestaurantReview(Integer restaurantId, Integer reviewId, Review review) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteRestaurantReview(Integer restaurantId, Integer reviewId) {
		boolean deleted = false;
		Review reviewToDelete = this.getRestaurantReviewByReviewId(restaurantId, reviewId);
		if (reviewToDelete != null) {
			reviewRepo.delete(reviewToDelete);
			deleted = true;
		}
		return deleted;
	}

	
}
