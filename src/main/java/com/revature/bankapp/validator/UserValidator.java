package com.revature.bankapp.validator;

import com.revature.bankapp.exception.ValidatorException;
import com.revature.bankapp.model.User;

public class UserValidator {

	public static void validateBeforeRegistration(User user) throws ValidatorException {
		
		//1. Check name is not null
		String name = user.getName();
		if ( name == null || "".equals(name.trim())) {
			throw new ValidatorException("Invalid Name");
		}
	}
}
