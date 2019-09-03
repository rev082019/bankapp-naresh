package com.revature.bankapp.model;

import org.junit.Test;

public class TestAccount {

	@Test
	public void testAccount() {
		int userId = 1;
		User user = new User();
		user.setId(userId);
		
		Account account = new Account();
		account.setUser(user);
		account.setBalance(100);
		account.setType("SAVINGS");
		
		System.out.println(account);
	}

}
