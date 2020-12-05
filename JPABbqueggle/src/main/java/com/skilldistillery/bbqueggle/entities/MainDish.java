package com.skilldistillery.bbqueggle.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "main_dish")
public class MainDish {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	@Column(name = "meat_type")
	private String meatType;

	private String description;

	@Column(name = "prep_type")
	private String prepType;

	private String image;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "main_dish_has_restaurant", inverseJoinColumns = @JoinColumn(name = "restaurant_id"), joinColumns = @JoinColumn(name = "main_dish_id"))
	private List<Restaurant> restaurant;
	
	public MainDish() {
		super();
	}

	public MainDish(int id, String name, String meatType, String description, String prepType, String image) {
		super();
		this.id = id;
		this.name = name;
		this.meatType = meatType;
		this.description = description;
		this.prepType = prepType;
		this.image = image;
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

	public String getMeatType() {
		return meatType;
	}

	public void setMeatType(String meatType) {
		this.meatType = meatType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrepType() {
		return prepType;
	}

	public void setPrepType(String prepType) {
		this.prepType = prepType;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	@JsonIgnore
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
		MainDish other = (MainDish) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MainDish [id=" + id + ", name=" + name + ", meatType=" + meatType + ", description=" + description
				+ ", prepType=" + prepType + ", image=" + image + "]";
	}

}
