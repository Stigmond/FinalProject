package com.skilldistillery.bbqueggle.services;


import java.util.List;

import com.skilldistillery.bbqueggle.entities.SideDish;

public interface SideDishService {

	List<SideDish> getAllSideDishes();

	SideDish findById(Integer id);

	SideDish create(SideDish sideDish, String username);

	SideDish update(Integer id, SideDish sideDish, String username);

	boolean delete(Integer id, String username);
}
