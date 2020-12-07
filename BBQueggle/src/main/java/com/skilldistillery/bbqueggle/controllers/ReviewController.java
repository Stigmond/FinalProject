package com.skilldistillery.bbqueggle.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.bbqueggle.entities.Review;
import com.skilldistillery.bbqueggle.services.ReviewService;

@CrossOrigin({ "*", "http://localhost:4210" })  // NEED ALL THESE ANNOTATIONS FOR ALL CONTROLLERS
@RestController
@RequestMapping("api")
public class ReviewController {

	@Autowired
	ReviewService revServ;

	
	@GetMapping("reviews/{restId}")
	public List<Review> getAllReviewsByRestaurant(@PathVariable Integer restId, HttpServletResponse response) {
		List<Review> reviews = revServ.getAllReviewsByRestaurantId(restId);
		return reviews;
	}
	
	@GetMapping("reviews/{restId}/{revId}")
	public Review getReviewByReviewIdAndRestaurantId(@PathVariable Integer restId, @PathVariable Integer revId, HttpServletResponse response) {
		Review review = revServ.getRestaurantReviewByReviewId(restId, revId);
		if (review == null) {
			response.setStatus(404);
			return review;
		}
		return review;
	}
	
	@PostMapping("reviews/{restId}")
	public Review addRestaurantReview(@PathVariable Integer restId, @RequestBody Review review) {
		System.out.println("***** Restaurant Id: " + restId);
		System.out.println("***** Review: " + review);
		review = revServ.createRestaurantReview(review, restId);
		return review;
	}
	
	@DeleteMapping("reviews/{restId}/{revId}")
	public void deleteRestaurantReview(@PathVariable Integer restId, @PathVariable Integer revId, HttpServletResponse response) {
		boolean deleted = revServ.deleteRestaurantReview(restId, revId);
		if (deleted == true) {
			response.setStatus(204);
		} else {
			response.setStatus(404);
		}
	}
	
	
}

	