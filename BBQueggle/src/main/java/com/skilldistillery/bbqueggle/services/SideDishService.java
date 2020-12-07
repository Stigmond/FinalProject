package com.skilldistillery.bbqueggle.services;

import java.util.List;

import com.skilldistillery.bbqueggle.entities.SideDish;

public interface SideDishService {

	List<SideDish> getAllSideDishes();

	SideDish getSideDishById(Integer id);

	SideDish create(SideDish sideDish);

	SideDish update(Integer id, SideDish sideDish);

	boolean delete(Integer id);
}
