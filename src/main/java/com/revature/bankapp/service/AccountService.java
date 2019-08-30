package com.revature.bankapp.service;

import java.util.List;

import com.revature.bankapp.dao.AccountDAO;
import com.revature.bankapp.exception.DBException;
import com.revature.bankapp.exception.ServiceException;
import com.revature.bankapp.model.Account;

public class AccountService {

	private AccountDAO accountDAO = new AccountDAO();
	
	public void createAccount(Account account) throws ServiceException {
		
		try {
			accountDAO.insert(account);
		} catch (DBException e) {
			e.printStackTrace();
			throw new ServiceException("Unable to create account");
		}
	}

	public List<Account> list(Integer userId) throws ServiceException {
		
		try {
			return accountDAO.list(userId);
		} catch (DBException e) {
			e.printStackTrace();
			throw new ServiceException("Unable to fetch accounts");
		}
	}
	
	public List<Account> list() throws ServiceException {
		
		try {
			return accountDAO.list();
		} catch (DBException e) {
			e.printStackTrace();
			throw new ServiceException("Unable to fetch accounts");
		}
	}
}
