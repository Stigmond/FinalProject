package com.skilldistillery.bbqueggle.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.bbqueggle.entities.Restaurant;
import com.skilldistillery.bbqueggle.entities.Review;
import com.skilldistillery.bbqueggle.entities.User;
import com.skilldistillery.bbqueggle.rankers.RestaurantRanker;
import com.skilldistillery.bbqueggle.rankers.RestaurantRankerImpl;
import com.skilldistillery.bbqueggle.services.RestaurantService;
import com.skilldistillery.bbqueggle.services.ReviewService;
import com.skilldistillery.bbqueggle.services.UserService;

@CrossOrigin({ "*", "http://localhost:4210" })  // NEED ALL THESE ANNOTATIONS FOR ALL CONTROLLERS
@RestController
@RequestMapping("api")
public class ReviewController {

	@Autowired
	ReviewService revServ;
	@Autowired
	RestaurantService restServ;
	@Autowired
	UserService userServ;
	
	RestaurantRanker restRank = new RestaurantRankerImpl();

	
	@GetMapping("reviews/{restId}")
	public List<Review> getAllReviewsByRestaurant(@PathVariable Integer restId, HttpServletResponse response) {
		List<Review> reviews = revServ.getAllReviewsByRestaurantId(restId);
		if (reviews.isEmpty() || reviews == null) {
			response.setStatus(404);
			return null;
		}
		return reviews;
	}
	
	@GetMapping("reviews/{restId}/score")
	public Double getReviewScore(@PathVariable Integer restId, HttpServletResponse response) {
		Restaurant restaurant = new Restaurant();
		restaurant = restServ.showRestaurant(restId);
		if (restaurant == null) {
			response.setStatus(404);
			return null;
		}
		Double score;
		score = restRank.getScore(restaurant);
		return score;
	}
	
	
	@GetMapping("reviews/{restId}/{revId}")
	public Review getReviewById(@PathVariable Integer restId, @PathVariable Integer revId, HttpServletResponse response) {
		if (restId == null || revId == null) {
			response.setStatus(404);
			return null;
		}
		Review review = revServ.getReviewByReviewId(restId, revId);
		if (review == null) {
			response.setStatus(404);
			return null;
		}
		return review;
	}
	
	@PostMapping("reviews/{restId}/{userId}")
	public Review addRestaurantReview(@PathVariable Integer restId, @PathVariable Integer userId, @RequestBody Review review, HttpServletResponse response, HttpServletRequest request) {
		Restaurant restaurant = restServ.showRestaurant(restId);
		User user = userServ.getUserById(userId);
		if (restaurant == null || user == null) {
			response.setStatus(404);
			return null;
		}
		if (review == null) {
			response.setStatus(400);
			return null;
		}
		review.setRestaurant(restaurant);
		review.setUser(user);
		review = revServ.createRestaurantReview(review);
		StringBuffer strUrl = request.getRequestURL().append("/").append(review.getId());
		String url = strUrl.toString();
		response.setHeader("Location", url);
		return review;
	}
	
	@PutMapping("reviews/{restId}/{revId}")
	public Review updateRestaurantReview(@PathVariable Integer restId, @PathVariable Integer revId, @RequestBody Review review, HttpServletResponse response) {
		if (restId == null || revId == null) {
			response.setStatus(404);
			return null;
		}
		review = revServ.updateRestaurantReview(restId, revId, review);
		if (review == null) {
			response.setStatus(404);
			return null;
		}
		return review;
	}
	
	@DeleteMapping("reviews/{restId}/{revId}")
	public void deleteRestaurantReview(@PathVariable Integer restId, @PathVariable Integer revId, HttpServletResponse response) {
		if (restId == null || revId == null) {
			response.setStatus(404);
		}
		boolean deleted = revServ.deleteRestaurantReview(restId, revId);
		if (deleted == true) {
			response.setStatus(204);
		} else {
			response.setStatus(404);
		}
	}
	
}

	