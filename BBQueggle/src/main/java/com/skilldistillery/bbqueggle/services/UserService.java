package com.skilldistillery.bbqueggle.services;

import java.util.List;

import com.skilldistillery.bbqueggle.entities.User;

public interface UserService {

	List<User> index();

	User getUserById(Integer Id);

	User createUser(User newUser);

	User updateUser(User user, Integer Id);

	boolean deleteUser(Integer Id);

}
