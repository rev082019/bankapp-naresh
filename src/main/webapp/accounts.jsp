<%@page import="java.util.List"%>
<%@page import="com.revature.bankapp.model.Account"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Accounts Page</h3>

<%
List<Account> accounts  = (List<Account>)request.getAttribute("ACCOUNTS_LIST");
%>


<h3>List accounts</h3>
<table border="1">
<thead>
<tr><th>Id </th> 
<th>User ID </th>
<th>Name </th>
<th>Account Type</th>

<th>Balance</th>
<th>Created Date</th>
</tr>
</thead>
<tbody>
<%
for(Account account: accounts) {
%>
<tr><td><%=account.getId() %> </td>
<td><%=account.getUser().getId() %>
<td><%=account.getUser().getName() %>
<td><%= account.getType() %> </td><td><%= account.getBalance() %> </td>
<td><%= account.getCreatedDate() %>

</tr>
<%} %>
</tbody>
</table>
<a href="createaccount.jsp">Add account</a>
</body>
</html>
</body>
</html>