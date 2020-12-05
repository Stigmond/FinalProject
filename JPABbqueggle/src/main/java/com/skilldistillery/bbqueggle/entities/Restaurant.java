package com.skilldistillery.bbqueggle.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	private String description;
	
	private String website;
	
	private String logo;
	
	@Column(name="dine_in")
	private Boolean dineIn;
	
	private String hours;
	
	private boolean enabled;



	public Restaurant() {
		super();
	}



	public Restaurant(int id, String name, String phoneNumber, String description, String website, String logo,
			Boolean dineIn, String hours, boolean enabled) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.description = description;
		this.website = website;
		this.logo = logo;
		this.dineIn = dineIn;
		this.hours = hours;
		this.enabled = enabled;
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



	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getWebsite() {
		return website;
	}



	public void setWebsite(String website) {
		this.website = website;
	}



	public String getLogo() {
		return logo;
	}



	public void setLogo(String logo) {
		this.logo = logo;
	}



	public Boolean getDineIn() {
		return dineIn;
	}



	public void setDineIn(Boolean dineIn) {
		this.dineIn = dineIn;
	}



	public String getHours() {
		return hours;
	}



	public void setHours(String hours) {
		this.hours = hours;
	}



	public boolean isEnabled() {
		return enabled;
	}



	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
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
		Restaurant other = (Restaurant) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", name=" + name + ", phoneNumber=" + phoneNumber + ", description="
				+ description + ", website=" + website + ", logo=" + logo + ", dineIn=" + dineIn + ", hours=" + hours
				+ ", enabled=" + enabled + "]";
	}
	
	
}
