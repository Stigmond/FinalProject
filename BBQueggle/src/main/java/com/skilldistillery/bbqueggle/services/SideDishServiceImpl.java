package com.skilldistillery.bbqueggle.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.bbqueggle.entities.SideDish;
import com.skilldistillery.bbqueggle.repositories.SideDishRepository;

@Service
public class SideDishServiceImpl implements SideDishService {

	@Autowired
	private SideDishRepository sRepo;

	@Override
	public List<SideDish> getAllSideDishes() {
		return sRepo.findAll();
	}

	@Override
	public SideDish findById(Integer id) {
		SideDish sideDish = null;
		Optional<SideDish> sideOpt = sRepo.findById(id);
		if (sideOpt.isPresent()) {
			sideDish = sideOpt.get();
		}
		sRepo.findById(id);
		return sideDish;
	}

	@Override
	public SideDish create(SideDish sideDish, String username) {
		sideDish = sRepo.saveAndFlush(sideDish);
		return sideDish;
	}

	@Override
	public SideDish update(Integer id, SideDish sideDish, String username) {
		Optional<SideDish> sdOpt = sRepo.findById(id);
		SideDish manageSd = null;
		if (sdOpt.isPresent()) {
			manageSd = sdOpt.get();
			if (sideDish.getName() != null) {
				manageSd.setName(sideDish.getName());
			}
			if (sideDish.getDescription() != null) {
				manageSd.setDescription(sideDish.getDescription());
			}
			if (sideDish.getImage() != null) {
				manageSd.setImage(sideDish.getImage());
			}
			sRepo.flush();
		}
		return manageSd;
	}

	@Override
	public boolean delete(Integer id, String username) {
		boolean deleted = false;
		Optional<SideDish> sOpt = sRepo.findById(id);
		if (sOpt.isPresent()) {
			sRepo.delete(sOpt.get());
		}
		return deleted;
	}

}
