package com.revature.bankapp.util;

import com.revature.bankapp.model.User;

public class MailUtil {

	public static void sendMail(User user) {
		String fromMailId = "support@revature.com";
		String toMailId = user.getEmail();
		String subject = "New User Registration";
		String content = "Welcome to RevaturePro. You have successfully registered. Your password is " + user.getPassword();
		
		System.out.println("Send Mail ");
		
	}
}
