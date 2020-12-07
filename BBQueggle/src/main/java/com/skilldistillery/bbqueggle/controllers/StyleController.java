package com.skilldistillery.bbqueggle.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.bbqueggle.entities.Style;
import com.skilldistillery.bbqueggle.services.StyleServiceImpl;

@CrossOrigin({ "*", "http://localhost:4210" })
@RequestMapping("api")
@RestController
public class StyleController {

	@Autowired
	private StyleServiceImpl svc;

	@GetMapping("style")
	public List<Style> index() {
		return svc.index();
	}

	@GetMapping("style/{styleId}")
	public Style getStyleById(@PathVariable Integer styleId, HttpServletResponse response) {
		Style style = svc.getStyleById(styleId);
		if (style == null) {
			response.setStatus(404);
		}
		return style;
	}

}
