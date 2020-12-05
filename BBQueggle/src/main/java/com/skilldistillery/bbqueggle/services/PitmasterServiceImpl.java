package com.skilldistillery.bbqueggle.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.bbqueggle.entities.Pitmaster;
import com.skilldistillery.bbqueggle.repositories.PitmasterRepository;

@Service
public class PitmasterServiceImpl implements PitmasterService{

	@Autowired
	PitmasterRepository pitmasterRepo;
	
	@Override
	public List<Pitmaster> getAllPitmasters() {
		List<Pitmaster> allPitmasters = null;
		allPitmasters = pitmasterRepo.findAll();
		return allPitmasters;
	}

	@Override
	public Pitmaster getPitmasterById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pitmaster createPitmaster(Pitmaster pitmaster) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pitmaster updatePitmaster(Integer id, Pitmaster pitmaster) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deletePitmaster(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

}
