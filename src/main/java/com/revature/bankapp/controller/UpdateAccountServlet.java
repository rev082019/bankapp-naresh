package com.revature.bankapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.bankapp.dao.UserDAO;
import com.revature.bankapp.exception.DBException;

/**
 * Servlet implementation class UpdateAccountServlet
 */
public class UpdateAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String status = request.getParameter("status");
		Integer id = Integer.parseInt(userId);
		Boolean active = Boolean.parseBoolean(status);
		
		UserDAO userDAO = new UserDAO();
		try {
			userDAO.updateAccount(id, active);
			
			response.sendRedirect("ListUserServlet");
		}catch (DBException e) {
			e.printStackTrace();
		}
	}


}
