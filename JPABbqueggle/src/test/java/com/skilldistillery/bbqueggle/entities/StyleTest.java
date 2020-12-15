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

class StyleTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Style style;

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
		style = em.find(Style.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		style = null;
	}

	@Test
	void test() {
		assertNotNull(style);
		assertEquals("Texas Style", style.getName());
//		assertEquals("Our pits are 100% wood fired with oak,"
//				+ " a slower burning wood than the mesquite used by others.", style.getDescription());
		
		}
	
	@Test
	void test2() {
		assertNotNull(style);
		assertNotNull(style.getRestaurant());
		assertTrue(style.getRestaurant().size() > 0);
		assertEquals("Rudy's \"Country Store\" and Bar-B-Q", style.getRestaurant().get(0).getName());
	}
}
