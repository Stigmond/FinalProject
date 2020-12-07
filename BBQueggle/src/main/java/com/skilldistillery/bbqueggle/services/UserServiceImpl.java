package com.skilldistillery.bbqueggle.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.bbqueggle.entities.Chain;
import com.skilldistillery.bbqueggle.entities.User;
import com.skilldistillery.bbqueggle.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public List<User> index() {
		List<User> allUsers = userRepo.findAll();
		return allUsers;
	}

	@Override
	public User getUserById(Integer Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User createUser(User newUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(User user, Integer Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteUser(Integer Id) {
		// TODO Auto-generated method stub
		return false;
	}

}
