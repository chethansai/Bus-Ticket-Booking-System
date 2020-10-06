<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
body{
  background-image:url('bus.jpg');
  height:"100";
  width:"100";
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String name=(String)session.getAttribute("uid"); 
//out.print("Hello User: You have entered the name: "+name); 
%>
<center>
		<h1 style="color: white; font-size: 40px;">
			<marquee scrollamount=10 width="500px"><i>WELCOME <%=name%></i></marquee>
		</h1>
		</br>
		</br>
		
		
		<form method="post" action="/BTMS1/selectsrcdest.jsp">
			<button type="submit" style="width: 500px; height: 100px; font-size : 30px;">
				<i>BOOK TICKETS</i>
			</button>
		</form><br><br><br>
		<form method="post" action="/BTMS1/showmybookings.jsp">
			<button type="submit" style="width: 500px; height: 100px;font-size : 30px;">
				<i>SHOW MY BOOKINGS</i>
			</button>
		</form>
		</br>
		</br>
		<!--  <form method="post" action="/BTMS1/cancelbooking.jsp">
			<button type="submit" style="width: 500px; height: 100px;font-size : 30px;">
				<i>CANCEL BOOKINGS</i>
			</button>
		</form>	-->	  
		</br>
		</br>
		<form method="post" action="/BTMS1/showbusdetails">
			<button type="submit" style="width: 500px; height: 100px;font-size : 30px;">
				<i>SHOW BUS DETAILS</i>
			</button>
		</form></br>
		</br><br><br>
		<form method="post" action="/BTMS1/logoutsession">
			<button type="submit" style="width: 200px; height: 50px;font-size : 30px; onclick="window.location.href=/BTMS1/logoutsession"">
				<i>LOGOUT</i>
			</button>
		</form>
	</center>
</body>
</html>