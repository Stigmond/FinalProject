package com.skilldistillery.bbqueggle.services;

import java.util.List;
import java.util.Optional;

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
		Optional<User> userOpt = userRepo.findById(Id);
		User user = null;
		if (userOpt.isPresent()) {
			user = userOpt.get();
		}
		return user;
	}

	@Override
	public User createUser(User newUser) {
		userRepo.saveAndFlush(newUser);
		return userRepo.save(newUser);
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
