<%@page import="com.revature.bankapp.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
User user  = (User)session.getAttribute("LOGGED_IN_USER");
%>


<h3>Update Profile</h3>
<form action="UpdateProfileServlet">
<table border="1">
<tr><th>Id </th> <td> <input type="text" name="userId" value="<%=user.getId() %>" readonly> </td> </tr>
<tr><th>Name</th> <td> <input type="text" name="name" value="<%= user.getName() %>"> </td> </tr>
<tr><th>Email</th> <td> <%= user.getEmail() %> </td> </tr>
<tr><th><button type="submit">Submit</button></th></tr>
</table>
</form>
</body>
</html>