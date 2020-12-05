package com.skilldistillery.bbqueggle.services;

import java.util.List;

import com.skilldistillery.bbqueggle.entities.Pitmaster;

public interface PitmasterService {

	List<Pitmaster> getAllPitmasters();
	
	Pitmaster getPitmasterById(Integer id);
	
	Pitmaster createPitmaster(Pitmaster newPitmaster);
	
	Pitmaster updatePitmaster(Integer id, Pitmaster pitmaster);
	
	boolean deletePitmaster(Integer id);
}
