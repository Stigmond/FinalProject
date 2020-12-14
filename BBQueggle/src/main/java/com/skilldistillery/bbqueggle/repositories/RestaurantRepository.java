package com.skilldistillery.bbqueggle.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skilldistillery.bbqueggle.entities.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

	List<Restaurant> findByAddress_State(String state);
	
	List<Restaurant> findByAddress_StateAndNameLike(String state, String name);
	
	List<Restaurant> findByAddress_StateAndMainDishes_MeatType(String state, String meatType);
		
	@Query("SELECT r FROM Restaurant r JOIN r.sideDishes rsd WHERE r.address.state = :state AND (rsd.name LIKE :name OR rsd.description LIKE :description)")
	List<Restaurant> queryByStateAndSideDish(@Param("state") String state, @Param("name") String name, @Param("description") String description);

	List<Restaurant> findByAddress_StateAndStyle_Id(String state, Integer styleId);
		
	Restaurant findByPitmaster_Id(Integer pitmaster);
	
	@Query("SELECT r FROM Restaurant r JOIN r.mainDishes rmd WHERE r.address.state = :state AND (rmd.name LIKE :name OR rmd.description LIKE :description)")
	List<Restaurant> queryByStateAndMainDish(@Param("state") String state, @Param("name") String name, @Param("description") String description);
}
