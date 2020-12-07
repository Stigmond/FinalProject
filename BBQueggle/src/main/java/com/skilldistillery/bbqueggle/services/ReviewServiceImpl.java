package com.skilldistillery.bbqueggle.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.bbqueggle.entities.Review;
import com.skilldistillery.bbqueggle.repositories.ReviewRepository;

@Service
public class ReviewServiceImpl implements ReviewService{

	@Autowired
	ReviewRepository reviewRepo;
	
	@Override
	public List<Review> getAllReviewsByRestaurantId(Integer RestaurantId) {
		List<Review> reviews = new ArrayList<>();
		reviews = reviewRepo.findByRestaurant_Id(RestaurantId);
		return reviews;
	}

	@Override
	public Review getRestaurantReviewByReviewId(Integer RestaurantId, Integer ReviewId) {
		return null;
	}

	@Override
	public Review createRestaurantReview(Review review) {
		if (review == null) {
			return null;
		}
		review.setReviewDate(LocalDate.now());
		if (review.getReview() == null || review.getReview().equals("")) {
			review.setReview("No comments given.");
		}
		reviewRepo.saveAndFlush(review);
		return review;
	}

	@Override
	public Review updateRestaurantReview(Integer RestaurantId, Integer ReviewId, Review review) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteRestaurantReview(Integer RestaurantId, Integer ReviewId) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
