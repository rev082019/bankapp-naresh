package com.revature.bankapp.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.bankapp.exception.DBException;
import com.revature.bankapp.model.User;

public class UserDAOTest {

	UserDAO userDAO = new UserDAO();
	
	@Test
	public void testValidLogin() {

		String email = "n@gmail.com";
		String password = "pass123";
		UserDAO userDAO = new UserDAO();
		User user = null;
		try {
			user = userDAO.login(email, password);
		} catch (DBException e) {
			e.printStackTrace();
		}
		assertNotNull(user);
	}
	
	@Test
	public void testInValidLogin() {

		String email = "";
		String password = "";
		UserDAO userDAO = new UserDAO();
		User user = null;
		try {
			user = userDAO.login(email, password);
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNull(user);
	}
	
	
	@Test
	public void testDeactivateAccount() {
		
		int userId = 100;
		
		try {
			userDAO.deactivateAccount(userId);
		} catch (DBException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testActivateAccount() {
		
		int userId = 1;
		
		try {
			userDAO.activateAccount(userId);
		} catch (DBException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testUpdateActivateAccount() {
		
		int userId = 1;
		
		try {
			Boolean status = true; // activate account
			userDAO.updateAccount(userId, status);
		} catch (DBException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testUpdateDeactivateAccount() {
		
		int userId = 1;
		
		try {
			Boolean status = false; // deactivate account
			userDAO.updateAccount(userId, status);
		} catch (DBException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testFindOne() {
		int userId = 1;
		User user = userDAO.findOne(userId);
		assertNotNull(user);
	}
	
	@Test
	public void testFindOneInvalidUserId() {
		int userId = -1;
		User user = userDAO.findOne(userId);
		assertNull(user);
	}

}
