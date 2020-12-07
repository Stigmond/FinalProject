package com.skilldistillery.bbqueggle.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		Optional<User> userOpt = userRepo.findById(Id);
		User managedUser = null;
		if (userOpt.isPresent()) {
			managedUser = userOpt.get();

			if (user.getFirstName() != null) {
				managedUser.setFirstName(user.getFirstName());
			}
			if (user.getLastName() != null) {
				managedUser.setLastName(user.getLastName());
			}
			if (user.getUsername() != null) {
				managedUser.setUsername(user.getUsername());
			}
			if (user.getPassword() != null) {
				managedUser.setPassword(user.getPassword());
			}
			if (user.getLastName() != null) {
				managedUser.setEmail(user.getEmail());
			}
			if (user.getEnabled() != null) {
				managedUser.setEnabled(user.getEnabled());
			}
			if (user.getRole() != null) {
				managedUser.setRole(user.getRole());
			}
			if (user.getImage() != null) {
				managedUser.setImage(user.getImage());
			}
			if (user.getAddress() != null) {
				managedUser.setAddress(user.getAddress());
			}

			userRepo.flush();
		}
		return managedUser;
	}

	@Override
	public boolean deleteUser(Integer Id) {
		boolean deleted = false;
		Optional<User> userOpt = userRepo.findById(Id);
		if (userOpt.isPresent()) {
			userRepo.deleteById(Id);
			deleted = true;
		}
		return deleted;
	}

}
