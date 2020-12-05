package com.skilldistillery.bbqueggle.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Style {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private String description;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "style_has_restaurant", inverseJoinColumns = @JoinColumn(name = "restaurant_id"), joinColumns = @JoinColumn(name = "style_id"))
	private List<Restaurant> restaurant;
	

	public Style() {
		super();
	}

	public Style(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Restaurant> getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(List<Restaurant> restaurant) {
		this.restaurant = restaurant;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Style other = (Style) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Style [id=" + id + ", name=" + name + ", description=" + description + "]";
	}

}
