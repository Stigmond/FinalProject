package com.skilldistillery.bbqueggle.services;

import java.util.List;

import com.skilldistillery.bbqueggle.entities.Pitmaster;

public interface PitmasterService {

	List<Pitmaster> getAllPitmasters();
	
	Pitmaster getPitmasterById(Integer id, String username);
	
	Pitmaster createPitmaster(Pitmaster newPitmaster, String username);
	
	Pitmaster updatePitmaster(Integer id, Pitmaster pitmaster, String username);
	
	boolean deletePitmaster(Integer id, String username);
}
