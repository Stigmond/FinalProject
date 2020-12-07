package com.skilldistillery.bbqueggle.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.bbqueggle.entities.Restaurant;
import com.skilldistillery.bbqueggle.entities.Review;
import com.skilldistillery.bbqueggle.services.RestaurantServiceImpl;
import com.skilldistillery.bbqueggle.services.ReviewServiceImpl;

@CrossOrigin({ "*", "http://localhost:4210" })  // NEED ALL THESE ANNOTATIONS FOR ALL CONTROLLERS
@RestController
@RequestMapping("api")
public class ReviewController {

	@Autowired
	ReviewServiceImpl revServ;
	RestaurantServiceImpl restServ;
	
	@GetMapping("reviews/{restId}")
	public List<Review> getAllReviewsByRestaurant(@PathVariable Integer restId, HttpServletResponse response) {
		List<Review> reviews = revServ.getAllReviewsByRestaurantId(restId);
		return reviews;
	}
	
	
	@PostMapping("reviews/{restId}")
	public Review addRestaurantReview(@PathVariable Integer restId, @RequestBody Review review, HttpServletResponse response, HttpServletRequest request) {
		Restaurant restaurant = restServ.showRestaurant(restId);
		if (restaurant == null) {
			response.setStatus(404);
			return null;
		}
		review = revServ.createRestaurantReview(review);
		if (review == null) {
			response.setStatus(400);
			return null;
		}
		// TODO SET LOCATION
		return review;
	}
}

	