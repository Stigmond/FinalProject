package com.skilldistillery.bbqueggle.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.skilldistillery.bbqueggle.entities.User;
import com.skilldistillery.bbqueggle.repositories.UserRepository;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private UserRepository userRepo;

	@Override
	public User register(User user) {
//		System.out.println(user.getPassword());
//		System.out.println(encoder.encode(user.getPassword()));
		user.setPassword(encoder.encode(user.getPassword()));
		user.setEnabled(true);
		user.setRole("ROLE_USER");
		userRepo.saveAndFlush(user);
		return user;
	}

	@Override
	public User getUser(String username) {
		return userRepo.findByUsername(username);
	}

}
