package com.skilldistillery.bbqueggle.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Pitmaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	private String description;

	private String image;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "restaurant_id")
	private Restaurant restaurant;

	public Pitmaster() {
		super();
	}

	public Pitmaster(int id, String firstName, String lastName, String description, String image,
			Restaurant restaurant) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.description = description;
		this.image = image;
		this.restaurant = restaurant;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
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
		Pitmaster other = (Pitmaster) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pitmaster [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", description="
				+ description + ", image=" + image + ", restaurant=" + restaurant + "]";
	}

}
