package com.revature.bankapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.revature.bankapp.exception.ServiceException;
import com.revature.bankapp.model.User;
import com.revature.bankapp.service.UserService;

/**
 * Servlet implementation class RegisterServletJSON
 */
public class RegisterServletJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name= request.getParameter("name");
		String email  = request.getParameter("email");
		String password = request.getParameter("password");
		
		response.setContentType("application/json");
		
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		System.out.println(user);
		
		PrintWriter out = response.getWriter();
		JsonObject json = new JsonObject();
		
		try {
			UserService.register(user);
			
			json.addProperty("message", "success");
			
		} catch (ServiceException e) {
			e.printStackTrace();
			//json.addProperty("message", e.getMessage());
			response.setStatus(500);
			json.addProperty("errorMessage",e.getMessage());
			
		} 
		out.write(json.toString());
		out.flush();
		
	}

}
