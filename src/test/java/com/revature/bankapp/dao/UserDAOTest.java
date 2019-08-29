package com.revature.bankapp.dao;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserDAOTest {

	@Test
	public void testValidLogin() {

		String email = "n@gmail.com";
		String password = "pass123";
		UserDAO userDAO = new UserDAO();
		boolean isValidLogin = userDAO.login(email, password);
		assertTrue(isValidLogin);
	}
	
	@Test
	public void testInValidLogin() {

		String email = "";
		String password = "";
		UserDAO userDAO = new UserDAO();
		boolean isValidLogin = userDAO.login(email, password);
		assertFalse(isValidLogin);
	}

}
