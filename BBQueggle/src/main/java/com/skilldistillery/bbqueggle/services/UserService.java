package com.skilldistillery.bbqueggle.services;

import java.util.List;

import com.skilldistillery.bbqueggle.entities.User;

public interface UserService {

	List<User> index(String username);

	User getUserById(String username, Integer Id);

	User createUser(String username, User newUser);

	User updateUser(String username, User user, Integer Id);

	boolean deleteUser(String username, Integer Id);

}
