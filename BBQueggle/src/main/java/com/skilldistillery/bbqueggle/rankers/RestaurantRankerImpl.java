package com.skilldistillery.bbqueggle.rankers;

import java.util.Comparator;
import java.util.List;

import com.skilldistillery.bbqueggle.entities.Restaurant;

public class RestaurantRankerImpl implements RestaurantRanker {
	
	@Override
	public List<Restaurant> rankRestaurants(List<Restaurant> restaurants) {
		restaurants.sort(new RestaurantScoreComparator());
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
		
		RestaurantRanker restRank = new RestaurantRankerImpl();
		
		@Override
		public int compare(Restaurant rest1, Restaurant rest2) {
			
			Double rest1Avg = restRank.getScore(rest1);
			Double rest2Avg = restRank.getScore(rest2);
			
			if (rest1Avg > rest2Avg) {
				return -1;
			} else if (rest1Avg < rest2Avg) {
				return 1;
			} else
				return rest1.getName().compareTo(rest2.getName());
		}
	}
}
