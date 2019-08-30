package com.revature.bankapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.bankapp.dao.AccountDAO;
import com.revature.bankapp.exception.ServiceException;
import com.revature.bankapp.model.Account;
import com.revature.bankapp.model.User;
import com.revature.bankapp.service.AccountService;

/**
 * Servlet implementation class InsertAccountServlet
 */
public class InsertAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userId = request.getParameter("userId");
		String accountType = request.getParameter("accountType");
		
		User user = new User();
		user.setId(Integer.parseInt(userId));
		
		Account account = new Account();
		account.setUser(user);
		account.setType(accountType);
		account.setBalance(0);
		
		AccountService accountService = new AccountService();
		try {
			accountService.createAccount(account);
			response.sendRedirect("ListAccountServlet?userId=" + userId);
		} catch (ServiceException e) {
			e.printStackTrace();
			response.sendRedirect("createaccount.jsp?message=" + e.getMessage());
		}
		
		
	}

}
