package com.skilldistillery.bbqueggle.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.skilldistillery.bbqueggle.entities.MainDish;
import com.skilldistillery.bbqueggle.repositories.MainDishRepository;

public class MainDishServiceImpl implements MainDishService {

	@Autowired
	private MainDishRepository mainDishRepo;

	@Override
	public List<MainDish> index() {
		List<MainDish> allMainDishes = mainDishRepo.findAll();
		return allMainDishes;
	}

	@Override
	public MainDish getMainDishById(Integer id) {
		Optional<MainDish> mainDishOpt = mainDishRepo.findById(id);
		MainDish mainDish = null;
		if (mainDishOpt.isPresent()) {
			mainDish = mainDishOpt.get();
		}
		return mainDish;
	}

	@Override
	public MainDish createMainDIsh(MainDish newMainDIsh) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MainDish updateMainDish(Integer id, MainDish mainDish) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteMainDish(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

}
