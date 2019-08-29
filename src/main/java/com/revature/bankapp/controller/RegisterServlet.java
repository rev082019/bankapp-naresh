package com.revature.bankapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.bankapp.exception.ServiceException;
import com.revature.bankapp.model.User;
import com.revature.bankapp.service.UserService;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name= request.getParameter("name");
		String email  = request.getParameter("email");
		String password = request.getParameter("password");
		
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		
		try {
			UserService.register(user);
			response.sendRedirect("index.jsp");
		} catch (ServiceException e) {
			e.printStackTrace();
			response.sendRedirect("register.jsp?message=" + e.getMessage());
		} 
		
	}

}
