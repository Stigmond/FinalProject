package com.skilldistillery.bbqueggle.entities;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RestaurantTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Restaurant restaurant;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		 emf = Persistence.createEntityManagerFactory("BBQPU");

	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		restaurant = em.find(Restaurant.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		restaurant = null;
	}
	@Test
	void test() {
		assertNotNull(restaurant);
		assertEquals("Rudy's \"Country Store\" and Bar-B-Q", restaurant.getName());
	}

}
