package com.skilldistillery.bbqueggle.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.bbqueggle.entities.Chain;
import com.skilldistillery.bbqueggle.entities.User;
import com.skilldistillery.bbqueggle.services.UserServiceImpl;

@CrossOrigin({ "*", "http://localhost:4210" })
@RequestMapping("api")
@RestController
public class UserController {

	@Autowired
	private UserServiceImpl svc;

	@GetMapping("user")
	public List<User> index() {
		return svc.index();
	}

	@GetMapping("user/{userId}")
	public User getUserById(@PathVariable Integer userId, HttpServletResponse response) {
		User user = svc.getUserById(userId);
		if (user == null) {
			response.setStatus(404);
		}
		return user;
	}

}
