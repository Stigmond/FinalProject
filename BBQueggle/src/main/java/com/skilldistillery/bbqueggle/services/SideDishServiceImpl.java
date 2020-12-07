package com.skilldistillery.bbqueggle.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.skilldistillery.bbqueggle.entities.SideDish;
import com.skilldistillery.bbqueggle.repositories.SideDishRepository;

public class SideDishServiceImpl implements SideDishService {

	@Autowired
	private SideDishRepository sRepo;
	
	@Override
	public List<SideDish> index() {
		return sRepo.findAll();
	}

	@Override
	public SideDish getSideDishById(Integer id) {
		SideDish sideDish = null;
		Optional<SideDish> sideOpt = sRepo.findById(id);
		if(sideOpt.isPresent()) {
			sideDish = sideOpt.get();
			}
		sRepo.findById(id);
		return sideDish;
	}

	@Override
	public SideDish create(SideDish sideDish) {
		
		return null;
	}

	@Override
	public SideDish update(Integer id, SideDish sideDish) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

}
