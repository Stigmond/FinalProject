package com.skilldistillery.bbqueggle.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SideDishTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private SideDish sideDish;

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
		sideDish = em.find(SideDish.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		sideDish = null;
	}

	@Test
	void test() {
		assertNotNull(sideDish);
		assertEquals("JUMBO SMOKED POTATO WITH 2 MEATS", sideDish.getName());
		assertEquals("Potato stacked with meat of your choice and cheese", sideDish.getDescription());
		}
	@Test
	void test2() {
		assertNotNull(sideDish);
		assertNotNull(sideDish.getRestaurants());
		assertTrue(sideDish.getRestaurants().size() >0);
		assertEquals("Rudy's \"Country Store\" and Bar-B-Q", sideDish.getRestaurants().get(0).getName());
		
	}

}