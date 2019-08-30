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
User user  = (User)request.getAttribute("USER_DETAIL");
%>


<h3>Update User Details</h3>
<form action="UpdateUserServlet">
<table border="1">
<tr><th>Id </th> <td> <input type="text" name="userId" value="<%=user.getId() %>" readonly> </td> </tr>
<tr><th>Name</th> <td> <input type="text" name="name" value="<%= user.getName() %>"> </td> </tr>
<tr><th>Email</th> <td> <%= user.getEmail() %> </td> </tr>
<tr><th><button type="submit">Submit</button></th></tr>
</table>
</form>
</body>
</html>