<%@page import="java.util.List"%>
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
List<User> users  = (List<User>)request.getAttribute("USERS_LIST");
%>


<h3>List Users</h3>
<table border="1">
<thead>
<tr><th>Id </th> 
<th>Name</th>
<th>Email</th>
<th>Active</th>
<th colspan="2">Action</th>
</tr>
</thead>
<tbody>
<%
for(User user: users) {
%>
<tr><td><%=user.getId() %> </td><td><%= user.getName() %> </td><td><%= user.getEmail() %> </td>
<td><%=user.getActive() %></td>
<td><a href="UpdateAccountServlet?userId=<%=user.getId()%>&status=true">Activate</a></td>
<td><a href="UpdateAccountServlet?userId=<%=user.getId()%>&status=false">DeActivate</a></td>
<td><a href="ShowUserServlet?userId=<%=user.getId()%>">View</a></td>
<td><a href="DeleteUserServlet?userId=<%=user.getId()%>">Delete</a></td>
</tr>
<%} %>
</tbody>
</table>
<a href="register.jsp">Add User</a>
</body>
</html>