package com.skilldistillery.bbqueggle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.bbqueggle.entities.SideDish;

public interface SideDishRepository extends JpaRepository<SideDish, Integer> {

	SideDish findById(int id);
}
