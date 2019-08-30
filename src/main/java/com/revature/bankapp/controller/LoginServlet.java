package com.revature.bankapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.bankapp.dao.UserDAO;
import com.revature.bankapp.model.User;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		PrintWriter out = response.getWriter();
		out.println("Email:" + email);
		out.println("Password:" + password);

		User user = null;
		try {
			UserDAO userDAO = new UserDAO();
			user = userDAO.login(email, password);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (user != null) {
			//request.setAttribute("LOGGED_IN_USER", user);
			
			HttpSession session = request.getSession();
			session.setAttribute("LOGGED_IN_USER", user);
			if (user.getRole().equals("U")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
				dispatcher.forward(request, response);
			}
			else if (user.getRole().equals("A")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp");
				dispatcher.forward(request, response);
			}
		} else {
			response.sendRedirect("index.jsp?message=Invalid Login Credentials");
		}
	}

}
