package com.skilldistillery.bbqueggle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.bbqueggle.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
