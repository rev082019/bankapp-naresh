package com.revature.bankapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.bankapp.dao.UserDAO;
import com.revature.bankapp.model.User;

/**
 * Servlet implementation class ShowUserServlet
 */
public class ShowUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		Integer id = Integer.parseInt(userId);
		UserDAO userDAO = new UserDAO();
		User user = userDAO.findOne(id);
		
		request.setAttribute("USER_DETAIL", user);
		RequestDispatcher dispatcher = request.getRequestDispatcher("viewuser.jsp");
		dispatcher.forward(request, response);
	}

}
