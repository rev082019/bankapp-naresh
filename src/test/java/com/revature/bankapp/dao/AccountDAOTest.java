package com.revature.bankapp.dao;

import org.junit.Test;

import com.revature.bankapp.exception.DBException;
import com.revature.bankapp.model.Account;
import com.revature.bankapp.model.User;

public class AccountDAOTest {

	@Test
	public void testCreateAccount() {

		int userId = 1;
		User user = new User();
		user.setId(userId);
		
		Account account = new Account();
		account.setUser(user);
		account.setBalance(100);
		account.setType("SAVINGS");
		
		AccountDAO accountDAO = new AccountDAO();
		try {
			accountDAO.insert(account);
		} catch (DBException e) {
			e.printStackTrace();
		}
		
	}

}
