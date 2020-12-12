package com.skilldistillery.bbqueggle.services;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.bbqueggle.entities.Restaurant;
import com.skilldistillery.bbqueggle.entities.Review;
import com.skilldistillery.bbqueggle.entities.User;
import com.skilldistillery.bbqueggle.repositories.ReviewRepository;

@Service
public class ReviewServiceImpl implements ReviewService{

	@Autowired
	ReviewRepository reviewRepo;
	@Autowired
	RestaurantService restServ;
	@Autowired
	UserService userServ;
	
	
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
	public Review createRestaurantReview(Review review, String username) {
		review.setReviewDate(LocalDate.now());
		if (review.getReview() == null || review.getReview().equals("")) {
			review.setReview("No comment available");
		}
		review = reviewRepo.saveAndFlush(review);
		return review;
	}

	@Override
	public Review updateRestaurantReview(Integer restaurantId, Integer reviewId, Review review, String username) {
		Review managedReview = this.getReviewByReviewId(restaurantId, reviewId);
		
		if (managedReview == null) {
			return null;
		}
		
		managedReview.setReviewScore(review.getReviewScore());
		
		StringBuilder updatedReview = new StringBuilder();
//		updatedReview.append(managedReview.getReview());
		updatedReview.append("[UPDATED ON: " + LocalDate.now() + "] ");
		updatedReview.append(review.getReview());
		
		managedReview.setReview(updatedReview.toString());
		review = reviewRepo.saveAndFlush(managedReview);
		return review;
		
	}

	@Override
	public boolean deleteRestaurantReview(Integer restaurantId, Integer reviewId, String username) {
		boolean deleted = false;
		Review reviewToDelete = this.getReviewByReviewId(restaurantId, reviewId);
		
		if (reviewToDelete != null) {
			Restaurant managedRestaurant = restServ.showRestaurant(restaurantId);
			managedRestaurant.getReviews().remove(reviewToDelete);
			User managedUser = userServ.getUserById(username, reviewToDelete.getUser().getId());
			managedUser.getReviews().remove(reviewToDelete);
			reviewRepo.delete(reviewToDelete);
			deleted = true;
		}
		return deleted;
	}

	
}
