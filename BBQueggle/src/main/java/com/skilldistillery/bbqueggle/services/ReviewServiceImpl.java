package com.skilldistillery.bbqueggle.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.bbqueggle.entities.Restaurant;
import com.skilldistillery.bbqueggle.entities.Review;
import com.skilldistillery.bbqueggle.repositories.ReviewRepository;

@Service
public class ReviewServiceImpl implements ReviewService{

	@Autowired
	ReviewRepository reviewRepo;
	
	
	@Override
	public List<Review> getAllReviewsByRestaurantId(Integer restaurantId) {
		List<Review> reviews = new ArrayList<>();
		reviews = reviewRepo.findByRestaurant_Id(restaurantId);
		return reviews;
	}

	public Review getReviewByReviewId(Integer reviewId) {
		Optional<Review> optRev = reviewRepo.findById(reviewId);
		Review review = null;
		if (optRev.isPresent()) {
			review = optRev.get();
		}
		return review;
	}
	
	@Override
	public Review createRestaurantReview(Review review) {
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
	public boolean deleteRestaurantReview(Integer reviewId) {
		return false;
	}

	
}
