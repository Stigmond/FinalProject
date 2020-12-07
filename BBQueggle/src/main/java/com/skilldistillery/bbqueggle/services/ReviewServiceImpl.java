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
	@Autowired
	RestaurantService restServ;
	
	
	@Override
	public List<Review> getAllReviewsByRestaurantId(Integer restaurantId) {
		List<Review> reviews = new ArrayList<>();
		reviews = reviewRepo.findByRestaurant_Id(restaurantId);
		return reviews;
	}

	public Review getReviewByReviewId(Integer restaurantId, Integer reviewId) {
		return reviewRepo.findByIdAndRestaurant_Id(reviewId, restaurantId);
		
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
		Review managedReview = this.getReviewByReviewId(restaurantId, reviewId);
		
		if (managedReview == null) {
			return null;
		}
		
		managedReview.setReviewScore(review.getReviewScore());
		
		StringBuilder updatedReview = new StringBuilder();
		updatedReview.append("[UPDATED ON: " + LocalDate.now() + "]\s");
		updatedReview.append(review.getReview());
		updatedReview.append("\s-----\s" + managedReview.getReview());
		
		managedReview.setReview(updatedReview.toString());
		review = reviewRepo.saveAndFlush(managedReview);
		return review;
		
	}

	@Override
	public boolean deleteRestaurantReview(Integer restaurantId, Integer reviewId) {
		boolean deleted = false;
		
		Review reviewToDelete = this.getReviewByReviewId(restaurantId, reviewId);
		if (reviewToDelete != null) {
			reviewRepo.delete(reviewToDelete);
			deleted = true;
		}
		return deleted;
	}

	
}
