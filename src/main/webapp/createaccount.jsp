<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Create Account</h3>
<%
String message = request.getParameter("message");
if (message != null){
	out.println("<font color='red'>" + message + "</font>");
}
%>

<form action="InsertAccountServlet">
User Id: <input type="number" name="userId" required /> <br/>
Account Type: <select name="accountType">
<option value="SAVINGS">SAVINGS</option>
<option value="BUSINESS">BUSINESS</option>
</select> <br/>
<button type="submit" >Submit</button>
</form>
</body>
</html>