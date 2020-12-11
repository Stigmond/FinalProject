package com.skilldistillery.bbqueggle.services;

import java.util.List;

import com.skilldistillery.bbqueggle.entities.MainDish;

public interface MainDishService {

	List<MainDish> index();

	MainDish getMainDishById(Integer id, String username);

	MainDish createMainDish(MainDish newMainDish, String username);

	MainDish updateMainDish(Integer id, MainDish mainDish, String username);

	boolean deleteMainDish(Integer id, String username);

}
