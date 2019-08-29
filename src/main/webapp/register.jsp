<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Register</h3>
<%
String message = request.getParameter("message");
if (message != null){
	out.println("<font color='red'>" + message + "</font>");
}
%>

<form action="RegisterServlet">

Name: <input type="text" name="name" required /> <br/>
Email : <input type="email" name="email" required /><br/>
Password : <input type="password" name="password" required /><br/>
<button type="submit" >Submit</button>
</form>
</body>
</html>