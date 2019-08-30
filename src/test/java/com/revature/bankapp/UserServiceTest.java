package com.revature.bankapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.revature.bankapp.exception.ServiceException;
import com.revature.bankapp.service.UserService;

public class UserServiceTest {

	@Test
	public void testDeactivateAccount() {
		
		int userId = 1;
		try {
			UserService.deactivateAccount(userId);
			
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		} 
	}
	
	@Test
	public void testDeactivateAccountInvalidUser() {
		
		int userId = -1;
		try {
			UserService.deactivateAccount(userId);
			fail();
		} catch (ServiceException e) {
			assertEquals("Invalid userId" , e.getMessage());
			
		} 
	}

}
