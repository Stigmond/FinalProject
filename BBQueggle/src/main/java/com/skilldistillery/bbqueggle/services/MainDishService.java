package com.skilldistillery.bbqueggle.services;

import java.util.List;

import com.skilldistillery.bbqueggle.entities.MainDish;

public interface MainDishService {

	List<MainDish> index();

	MainDish getMainDishById(Integer id);

	MainDish createMainDish(MainDish newMainDIsh);

	MainDish updateMainDish(Integer id, MainDish mainDish);

	boolean deleteMainDish(Integer id);

}
