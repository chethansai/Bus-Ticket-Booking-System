<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
<%ResultSet resultset =null;%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
		<h1 style="color: white; font-size: 40px;">
			<i>Bus  details added!!</i>
		</h1>
		</br>
		</br>
		
		
		<form method="get" action="addbushome.html">
			<button type="submit" style="width: 500px; height: 100px; font-size : 30px;">
				<i>ADD MORE BUS DETAILS</i>
			</button>
		</form>
		</br>
		</br>
		<form method="get" action="adminhome.html">
			<button type="submit" style="width: 500px; height: 100px;font-size : 30px;">
				<i>BACK TO HOME PAGE</i>
			</button>
		</form>
		</br>
		</br>
		</br>
		<form method="get" action="regs.html">
			<button type="submit" style="width: 200px; height: 50px;font-size : 30px;">
				<i>LOGOUT</i>
			</button>
		</form>
	</center>
</body>
</html>