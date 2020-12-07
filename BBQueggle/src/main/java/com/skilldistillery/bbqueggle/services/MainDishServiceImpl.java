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
	public MainDish createMainDish(MainDish newMainDish) {
		mainDishRepo.saveAndFlush(newMainDish);
		return mainDishRepo.save(newMainDish);
	}

	@Override
	public MainDish updateMainDish(Integer id, MainDish mainDish) {
		Optional<MainDish> mainDishOpt = mainDishRepo.findById(id);
		MainDish managedMainDish = null;
		if (mainDishOpt.isPresent()) {
			managedMainDish = mainDishOpt.get();

			if (mainDish.getName() != null) {
				managedMainDish.setName(mainDish.getName());
			}
			if (mainDish.getMeatType() != null) {
				managedMainDish.setMeatType(mainDish.getMeatType());
			}
			if (mainDish.getDescription() != null) {
				managedMainDish.setDescription(mainDish.getDescription());
			}
			if (mainDish.getPrepType() != null) {
				managedMainDish.setPrepType(mainDish.getPrepType());
			}
			if (mainDish.getImage() != null) {
				managedMainDish.setImage(mainDish.getImage());
			}

			mainDishRepo.flush();
		}
		return managedMainDish;
	}

	@Override
	public boolean deleteMainDish(Integer id) {
		boolean deleted = false;
		Optional<MainDish> restaurantOpt = mainDishRepo.findById(id);
		if (restaurantOpt.isPresent()) {
			mainDishRepo.deleteById(id);
			deleted = true;
		}
		return deleted;
	}

}
