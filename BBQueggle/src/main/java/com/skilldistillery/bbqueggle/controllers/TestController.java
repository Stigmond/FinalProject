package com.skilldistillery.bbqueggle.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin({ "*", "http://localhost:4210" })  // NEED ALL THESE ANNOTATIONS FOR ALL CONTROLLERS
@RestController
@RequestMapping("api")

public class TestController {

	@GetMapping("ping")
	public String ping() {
		return "pong";
	}
	
}
