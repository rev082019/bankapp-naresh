<%@page import="com.revature.bankapp.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Homepage</title>
</head>
<body>
<h3>Welcome to HomePage</h3>
<!-- Scriptlets -->
<%
User user = (User)session.getAttribute("LOGGED_IN_USER");
%>
Welcome <%=user.getName() %> ( <a href="LogoutServlet">Logout</a>)


<a href="profile.jsp">Update Profile</a>
</body>
</html>