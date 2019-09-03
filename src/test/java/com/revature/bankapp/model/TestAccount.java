package com.revature.bankapp.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestAccount {

	@Test
	public void testAccount() {
		int userId = 1;
		
		
		User user = new User();
		user.setId(userId);
		
		Account account = new Account();
		// how to set userId(FK) to account
		account.setUser(user); // set User object
		account.setBalance(100);
		account.setType("SAVINGS");
		
		assertEquals("SAVINGS", account.getType());
		
		// how to retreive userId from account
		Integer id = account.getUser().getId();
		
		assertEquals(new Integer(1), id);
	}

}
