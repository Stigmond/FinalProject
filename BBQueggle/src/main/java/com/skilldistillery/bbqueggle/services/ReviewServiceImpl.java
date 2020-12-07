package com.skilldistillery.bbqueggle.services;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Review getRestaurantReviewByReviewId(Integer RestaurantId, Integer ReviewId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Review createRestaurantReview(Integer RestaurantId) {
		// TODO Auto-generated method stub
		return null;
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
