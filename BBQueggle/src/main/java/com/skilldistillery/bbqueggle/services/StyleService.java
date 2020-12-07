package com.skilldistillery.bbqueggle.services;

import java.util.List;

import com.skilldistillery.bbqueggle.entities.Style;

public interface StyleService {

	List<Style>index();
	
	Style getStyleById(Integer Id);
	
	Style createStyle(Style newStyle);
	
	Style updateStyle(Style style, Integer Id);
	
	boolean deleteStyle(Integer Id);
}
