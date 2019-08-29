<html>
<body>
<h2>Login Page 3</h2>

<%
String message = request.getParameter("message");
if (message != null){
	out.println(message);
}
%>
<form action="LoginServlet">
Email : <input type="text" name="email" required />
<br/>
Password: <input type="password" name="password" required />
<br/>
<button type="submit">Submit</button>
<a href="register.jsp">Register</a>
</form>
</body>
</html> 
