package com.skilldistillery.bbqueggle.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.bbqueggle.entities.Style;
import com.skilldistillery.bbqueggle.repositories.StyleRepository;

@Service
public class StyleServiceImpl implements StyleService {

	@Autowired
	private StyleRepository styleRepo;

	@Override
	public List<Style> index() {
		List<Style> allStyles = styleRepo.findAll();
		return allStyles;
	}

	@Override
	public Style getStyleById(Integer Id) {
		Optional<Style> styleOpt = styleRepo.findById(Id);
		Style style = null;
		if (styleOpt.isPresent()) {
			style = styleOpt.get();
		}
		return style;
	}

	@Override
	public Style createStyle(Style newStyle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Style updateStyle(Style style, Integer Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteStyle(Integer Id) {
		// TODO Auto-generated method stub
		return false;
	}

}
