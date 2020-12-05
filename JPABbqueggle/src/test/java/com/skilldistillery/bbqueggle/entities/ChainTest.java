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

class ChainTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Chain chain;

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
		chain = em.find(Chain.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		chain = null;
	}

	@Test
	void test() {
		assertNotNull(chain);
		assertEquals("Rudy's \"Country Store\" and Bar-B-Q", chain.getName());
	}
	@Test
	void test2() {
		assertNotNull(chain);
		assertNotNull(chain.getRestaurants());
		assertTrue(chain.getRestaurants().size() > 0);
		assertEquals("Rudy's \"Country Store\" and Bar-B-Q", chain.getRestaurants().get(0).getName());
	}

}
