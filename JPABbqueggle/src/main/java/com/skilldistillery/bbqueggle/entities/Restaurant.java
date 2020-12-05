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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	@Column(name = "phone_number")
	private String phoneNumber;

	private String description;

	private String website;

	private String logo;

	@Column(name = "dine_in")
	private Boolean dineIn;

	private String hours;

	private boolean enabled;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;

	@OneToMany(mappedBy = "restaurant")
	@JsonIgnore
	private List<Review> reviews;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "chain_id")
	private Chain chain;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "side_dish_has_restaurant", inverseJoinColumns = @JoinColumn(name = "side_dish_id"), joinColumns = @JoinColumn(name = "restaurant_id"))
	private List<SideDish> sideDishes;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "sauce_has_restaurant", inverseJoinColumns = @JoinColumn(name = "sauce_id"), joinColumns = @JoinColumn(name = "restaurant_id"))
	private List<Sauce> sauces;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "main_dish_has_restaurant", inverseJoinColumns = @JoinColumn(name = "main_dish_id"), joinColumns = @JoinColumn(name = "restaurant_id"))
	private List<MainDish> mainDishes;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "style_has_restaurant", inverseJoinColumns = @JoinColumn(name = "style_id"), joinColumns = @JoinColumn(name = "restaurant_id"))
	private List<Style> style;

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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public Chain getChain() {
		return chain;
	}

	public void setChain(Chain chain) {
		this.chain = chain;
	}

	public List<SideDish> getSideDishes() {
		return sideDishes;
	}

	public void setSideDishes(List<SideDish> sideDishes) {
		this.sideDishes = sideDishes;
	}

	public List<Sauce> getSauces() {
		return sauces;
	}

	public void setSauces(List<Sauce> sauces) {
		this.sauces = sauces;
	}

	public List<MainDish> getMainDishes() {
		return mainDishes;
	}

	public void setMainDishes(List<MainDish> mainDishes) {
		this.mainDishes = mainDishes;
	}

	public List<Style> getStyle() {
		return style;
	}

	public void setStyle(List<Style> style) {
		this.style = style;
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
