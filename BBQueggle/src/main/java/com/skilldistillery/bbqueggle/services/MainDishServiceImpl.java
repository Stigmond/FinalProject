package com.skilldistillery.bbqueggle.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.bbqueggle.entities.MainDish;
import com.skilldistillery.bbqueggle.repositories.MainDishRepository;

@Service
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
	public MainDish createMainDish(MainDish newMainDish, String username) {
		mainDishRepo.saveAndFlush(newMainDish);
		return mainDishRepo.save(newMainDish);
	}

	@Override
	public MainDish updateMainDish(Integer id, MainDish mainDish, String username) {
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
			if (mainDish.getImage() != null) {
				managedMainDish.setImage(mainDish.getImage());
			}

			mainDishRepo.flush();
		}
		return managedMainDish;
	}

	@Override
	public boolean deleteMainDish(Integer id, String username) {
		boolean deleted = false;
		Optional<MainDish> restaurantOpt = mainDishRepo.findById(id);
		if (restaurantOpt.isPresent()) {
			mainDishRepo.deleteById(id);
			deleted = true;
		}
		return deleted;
	}

}
