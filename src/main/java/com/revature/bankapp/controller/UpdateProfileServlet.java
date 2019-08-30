package com.revature.bankapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.bankapp.dao.UserDAO;
import com.revature.bankapp.exception.DBException;
import com.revature.bankapp.model.User;

/**
 * Servlet implementation class UpdateProfileServlet
 */
public class UpdateProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		String name =  request.getParameter("name");
		UserDAO userDAO = new UserDAO();
		
		User user = new User();
		user.setId(Integer.parseInt(userId));
		user.setName(name);
		
		try {
			userDAO.updateProfile(user);
			response.sendRedirect("home.jsp");
		} catch (DBException e) {
			e.printStackTrace();
		}
		
	}


}
