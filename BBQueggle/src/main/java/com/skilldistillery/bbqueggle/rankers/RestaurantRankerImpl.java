package com.skilldistillery.bbqueggle.rankers;

import java.util.Comparator;
import java.util.List;

import com.skilldistillery.bbqueggle.entities.Restaurant;
import com.skilldistillery.bbqueggle.entities.Review;

public class RestaurantRankerImpl implements RestaurantRanker {
	
	@Override
	public List<Restaurant> rankRestaurants(List<Restaurant> restaurants) {
		restaurants.sort(new RestaurantScoreComparator());
//		System.out.println("******* RESTAURANT LIST: " + restaurants);
		return restaurants;	
	}

	public Double getScore(Restaurant restaurant) {
		Double score = 0.0;
		if (!restaurant.getReviews().isEmpty()) {
			for (int i = 0; i < restaurant.getReviews().size(); i++) {
				score += restaurant.getReviews().get(i).getReviewScore();
			}
			score /= restaurant.getReviews().size();
		}
		return score;
	}
		
	public class RestaurantScoreComparator implements Comparator<Restaurant> {

		@Override
		public int compare(Restaurant rest1, Restaurant rest2) {
			List<Review> rest1Reviews = rest1.getReviews();
			List<Review> rest2Reviews = rest2.getReviews();
			Double rest1Avg = 0.0;
			Double rest2Avg = 0.0;

			if (!rest1Reviews.isEmpty()) {
				for (int i = 0; i < rest1Reviews.size(); i++) {
					rest1Avg += rest1Reviews.get(i).getReviewScore();
				}
				rest1Avg /= rest1Reviews.size();

			}

			if (!rest2Reviews.isEmpty()) {
				for (int i = 0; i < rest2Reviews.size(); i++) {
					rest2Avg += rest2Reviews.get(i).getReviewScore();
				}
				rest2Avg /= rest2Reviews.size();
			}

			if (rest1Avg > rest2Avg) {
				return -1;
			} else if (rest1Avg < rest2Avg) {
				return 1;
			} else
				return rest1.getName().compareTo(rest2.getName());
		}
	}

}
