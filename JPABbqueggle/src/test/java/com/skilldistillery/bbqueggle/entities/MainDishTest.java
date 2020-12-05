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

class MainDishTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private MainDish mainDish;

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
		mainDish = em.find(MainDish.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		mainDish = null;
	}

	@Test
	void test() {
		assertNotNull(mainDish);
		assertEquals("Pork Spare Ribs", mainDish.getName());
		assertEquals("Pork", mainDish.getMeatType());
		assertEquals("Pork spare ribs are taken from the belly side of the pig's rib "
				+ "cage above the sternum (breast bone) and below the back ribs which "
				+ "extend about 6\" down from the spine.",mainDish.getDescription());
		
		}
	@Test
	void test2() {
		assertNotNull(mainDish);
		assertNotNull(mainDish.getRestaurant());
		assertTrue(mainDish.getRestaurant().size() > 0);
		assertEquals("Rudy's \"Country Store\" and Bar-B-Q", mainDish.getRestaurant().get(0).getName());
		}

}
