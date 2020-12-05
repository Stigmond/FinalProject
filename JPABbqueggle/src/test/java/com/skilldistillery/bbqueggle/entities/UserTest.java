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

class UserTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private User user;

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
		user = em.find(User.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		user = null;
	}

	@Test
	void test() {
		assertNotNull(user);
		assertEquals("admin", user.getUsername());
		assertEquals("fake@gmail.com", user.getEmail());
		}
	@Test
	void test2() {
		assertNotNull(user);
		assertNotNull(user.getAddress());
		assertEquals("315 South 31st Street", user.getAddress().getStreet());
		assertEquals("Colorado Springs", user.getAddress().getCity());
		assertEquals("CO", user.getAddress().getState());
		assertEquals("80904", user.getAddress().getZip());
	}

	@Test
	void test3() {
		assertNotNull(user);
		assertNotNull(user.getReview());
		assertTrue(user.getReview().size() > 0);
		assertEquals("tasty food", user.getReview().get(0).getReview());
	}
}
