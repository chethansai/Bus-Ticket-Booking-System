<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.sql.*" %>
<%ResultSet resultset =null;%>
<!DOCTYPE html>
<HTML>
<HEAD>
    <TITLE>Select element drop down box</TITLE>
</HEAD>

<BODY>
<form method="post" action="">
<center>
    <label>Enter User Name:</label>
  <input type="text" name="uname"><br><br>
  <label >Select Seats:</label>
  <input type="text" name="seats"><br><br><br>
  <input type="submit" value="Book Tickets">
</center>
</form>


</BODY>
</HTML>