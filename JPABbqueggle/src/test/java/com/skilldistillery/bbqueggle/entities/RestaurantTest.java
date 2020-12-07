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
	@Test
	void test2() {
		assertNotNull(restaurant);
		assertNotNull(restaurant.getAddress());
		assertEquals("315 South 31st Street", restaurant.getAddress().getStreet());
		assertEquals("Colorado Springs", restaurant.getAddress().getCity());
		assertEquals("CO", restaurant.getAddress().getState());
		assertEquals("80904", restaurant.getAddress().getZip());
	}
	
	@Test
	void test3() {
		assertNotNull(restaurant);
		assertNotNull(restaurant.getReviews());
		assertTrue(restaurant.getReviews().size() > 0);
		assertEquals("tasty food", restaurant.getReviews().get(0).getReview());
	}
	
	@Test
	void test4() {
		assertNotNull(restaurant);
		assertNotNull(restaurant.getChain());
		assertEquals("Rudy's \"Country Store\" and Bar-B-Q", restaurant.getChain().getName());
	}
	
	@Test
	void test5() {
		assertNotNull(restaurant);
		assertNotNull(restaurant.getSideDishes());
		assertTrue(restaurant.getSideDishes().size() > 0);
		assertEquals("JUMBO SMOKED POTATO WITH 2 MEATS", restaurant.getSideDishes().get(0).getName());
	}
	@Test
	void test6() {
		assertNotNull(restaurant);
		assertNotNull(restaurant.getSauces());
		assertTrue(restaurant.getSauces().size() > 0);
		assertEquals("ORIGINAL BAR-B-Q SAUCE", restaurant.getSauces().get(0).getName());
	}
	
	@Test
	void test7() {
		assertNotNull(restaurant);
		assertNotNull(restaurant.getMainDishes());
		assertTrue(restaurant.getMainDishes().size() > 0);
		assertEquals("Pork Spare Ribs", restaurant.getMainDishes().get(0).getName());
	}
	
	@Test
	void test8() {
		assertNotNull(restaurant);
		assertNotNull(restaurant.getStyle());
		assertTrue(restaurant.getStyle().size() > 0);
		assertEquals("Texas Style", restaurant.getStyle().get(0).getName());
	}
	
	@Test
	void test9() {
		assertNotNull(restaurant);
		assertEquals("Larry", restaurant.getPitmaster().getFirstName());
		assertEquals("Dude", restaurant.getPitmaster().getLastName());
	}
}
