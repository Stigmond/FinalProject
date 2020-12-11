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

	@PostMapping("style")
	public Style createStyle(@RequestBody Style newStyle, HttpServletResponse response, HttpServletRequest request, Principal principal) {
		Style createdStyle = null;
		try {
			createdStyle = svc.createStyle(newStyle, principal.getName());
			response.setStatus(201);
			StringBuffer url = request.getRequestURL();
			url.append("/").append(newStyle.getId());
			response.setHeader("Location", url.toString());

		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(400);
			newStyle = null;
		}
		return createdStyle;

	}

	@PutMapping("style/{styleId}")
	public Style updateStyle(@PathVariable Integer styleId, @RequestBody Style updatedStyle,
			HttpServletResponse response, Principal principal) {
		try {
			updatedStyle = svc.updateStyle(updatedStyle, styleId, principal.getName());
			if (updatedStyle == null) {
				response.setStatus(404);
				updatedStyle = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(400);
			updatedStyle = null;
		}
		return updatedStyle;
	}

	@DeleteMapping("style/{styleId}")
	public void deleteStyle(@PathVariable Integer styleId, HttpServletResponse response, Principal principal) {
		if (svc.deleteStyle(styleId, principal.getName())) {
			response.setStatus(204);

		} else {
			response.setStatus(404);
		}
	}
}
