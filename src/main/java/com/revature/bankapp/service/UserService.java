package com.revature.bankapp.service;

import com.revature.bankapp.dao.UserDAO;
import com.revature.bankapp.exception.DBException;
import com.revature.bankapp.exception.ServiceException;
import com.revature.bankapp.exception.ValidatorException;
import com.revature.bankapp.model.User;
import com.revature.bankapp.util.MailUtil;
import com.revature.bankapp.validator.UserValidator;

public class UserService {

	private static UserDAO userDAO = new UserDAO();
	
	public static void register(User user) throws ServiceException  {
		
		try {
			//Validate the inputs before calling your DAO
			UserValidator.validateBeforeRegistration(user);
			
			//if validation is success, then call dao.register
			userDAO.register(user);
			
			//send mail to the users
			MailUtil.sendMail(user);
			
		} catch (ValidatorException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
	}
	
	
	public static void deactivateAccount(int userId) throws ServiceException {
		
		try {
			User user = userDAO.findOne(userId);
			if (user == null) {
				throw new ServiceException("Invalid userId");
			}
			userDAO.deactivateAccount(userId);
		} catch (DBException e) {
			e.printStackTrace();
			throw new ServiceException("Unable to deactivate account for this userId -" + userId);
		}
	}
	
	public User login(String email, String password) throws ServiceException {
		User user = null;
		try {
			UserDAO userDAO = new UserDAO();
			user = userDAO.login(email, password);
		} catch (DBException e) {
			e.printStackTrace();
			throw new ServiceException("Unable to login");
			
		}
		return user;

	}
}
