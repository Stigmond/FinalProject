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

class SauceTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Sauce sauce;

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
		sauce = em.find(Sauce.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		sauce = null;
	}
	@Test
	void test() {
		assertNotNull(sauce);
		assertEquals("Texas Style Mop", sauce.getName());
	}
	@Test
	void test2() {
		assertNotNull(sauce);
		assertNotNull(sauce.getRestaurants());
		assertTrue(sauce.getRestaurants().size() > 0);
		assertEquals("Rudy's \"Country Store\" and Bar-B-Q", sauce.getRestaurants().get(0).getName());
	}

}
