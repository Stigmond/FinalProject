package com.skilldistillery.bbqueggle.services;

import java.util.List;

import com.skilldistillery.bbqueggle.entities.Style;

public interface StyleService {

	List<Style>index();
	
	Style getStyleById(Integer Id);
	
	Style createStyle(Style newStyle, String username);
	
	Style updateStyle(Style style, Integer Id, String username);
	
	boolean deleteStyle(Integer Id, String username);
}
