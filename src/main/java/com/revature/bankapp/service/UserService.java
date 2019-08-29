package com.revature.bankapp.service;

import com.revature.bankapp.dao.UserDAO;
import com.revature.bankapp.exception.DBException;
import com.revature.bankapp.exception.ServiceException;
import com.revature.bankapp.exception.ValidatorException;
import com.revature.bankapp.model.User;
import com.revature.bankapp.validator.UserValidator;

public class UserService {

	public static void register(User user) throws ServiceException  {
		
		try {
			UserDAO userDAO = new UserDAO();
			//Validate the inputs before calling your DAO
			UserValidator.validateBeforeRegistration(user);
			
			//if validation is success, then call dao.register
			userDAO.register(user);
			
		} catch (ValidatorException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
	}
}
