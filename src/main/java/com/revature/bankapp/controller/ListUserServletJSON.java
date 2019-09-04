package com.revature.bankapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.revature.bankapp.dao.UserDAO;
import com.revature.bankapp.model.User;

/**
 * Servlet implementation class ListUserServletJSON
 */
public class ListUserServletJSON extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDAO userDAO = new UserDAO();
		List<User> list = userDAO.list();
	
		
		//Convert List to JSON
		Gson gson = new Gson();
		String json = gson.toJson(list);
		
		// Write JSON as output.
		PrintWriter out = response.getWriter();
		out.write(json);
		out.flush();
	}


}
