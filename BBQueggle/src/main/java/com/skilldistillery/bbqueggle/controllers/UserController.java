package com.skilldistillery.bbqueggle.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.bbqueggle.entities.User;
import com.skilldistillery.bbqueggle.services.UserServiceImpl;

@CrossOrigin({ "*", "http://localhost:4210" })
@RequestMapping("api")
@RestController
public class UserController {

	@Autowired
	private UserServiceImpl svc;

	@GetMapping("user")
	public List<User> index(Principal principal) {
		return svc.index(principal.getName());
	}

	@GetMapping("user/{userId}")
	public User getUserById(@PathVariable Integer userId, HttpServletResponse response, Principal principal) {
//		User user = svc.getUserById(userId);
		User user = svc.getUserById(principal.getName(), userId);
		if (user == null) {
			response.setStatus(404);
		}
		return user;
	}

	@PostMapping("user")
	public User createUser(@RequestBody User newUser, HttpServletResponse response, HttpServletRequest request, Principal principal) {
		User createdUser = null;
		try {
			createdUser = svc.createUser(principal.getName(), newUser);
			response.setStatus(201);
			StringBuffer url = request.getRequestURL();
			url.append("/").append(newUser.getId());
			response.setHeader("Location", url.toString());

		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(400);
			newUser = null;
		}
		return createdUser;

	}

	@PutMapping("user/{userId}")
	public User updateUser(@PathVariable Integer userId, @RequestBody User updatedUser, HttpServletResponse response, Principal principal) {
		try {
			updatedUser = svc.updateUser(principal.getName(), updatedUser, userId);
			if (updatedUser == null) {
				response.setStatus(404);
				updatedUser = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(400);
			updatedUser = null;
		}
		return updatedUser;
	}

	@DeleteMapping("user/{userId}")
	public void deleteUser(@PathVariable Integer userId, HttpServletResponse response, Principal principal) {
		if (svc.deleteUser(principal.getName(), userId)) {
			response.setStatus(204);

		} else {
			response.setStatus(404);
		}
	}
}
