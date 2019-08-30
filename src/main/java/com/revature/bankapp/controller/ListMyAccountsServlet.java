package com.revature.bankapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.bankapp.exception.ServiceException;
import com.revature.bankapp.model.Account;
import com.revature.bankapp.service.AccountService;

/**
 * Servlet implementation class ListMyAccountsServlet
 */
public class ListMyAccountsServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("userId");
		Integer userId = Integer.parseInt(id);
		
		AccountService accountService = new AccountService();
		try {
			List<Account> list = accountService.list(userId);
			
			request.setAttribute("ACCOUNTS_LIST", list);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("accounts.jsp");
			dispatcher.forward(request, response);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

}
