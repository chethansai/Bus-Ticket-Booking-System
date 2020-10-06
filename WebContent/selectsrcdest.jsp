<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.sql.*" %>
<%ResultSet resultset =null;%>
<!DOCTYPE html>
<HTML>
<HEAD>
    <TITLE>Select element drop down box</TITLE>
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
</HEAD>

<BODY>

<%
    try{
//Class.forName("com.mysql.jdbc.Driver").newInstance();
//Connection connection = 
         //DriverManager.getConnection
           // ("jdbc:mysql://localhost/city?user=root&password=root");
Class.forName("com.mysql.cj.jdbc.Driver");
//String url="jdbc:mysql://localhost:3306/test";

Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");

       Statement statement = connection.createStatement() ;
       Statement statement1 = connection.createStatement() ;

       ResultSet src =statement.executeQuery("select distinct source from bus_details") ;
       ResultSet dest =statement1.executeQuery("select distinct dest from bus_details") ;
%>
<form method="post" action="/BTMS1/selectbus.jsp">
<center>
    <h1 style="color: white; font-size: 40px;"><i>SELECT SOURCE</i></h1>
        <select name="source" style="width:150px; height:25px; font-size:20px;">
        <%  while(src.next()){ %>
            <option value="<%=src.getString(1)%>"><%= src.getString(1)%></option>
        <% } %>
        </select><br><br><br>
     <h1 style="color: white; font-size: 40px;"> <i>SELECT DESTINATION</i></h1>
        <select name="dest" style="width:150px; height:25px; font-size:20px;">
        <%  while(dest.next()){ %>
            <option value="<%=dest.getString(1)%>"><%= dest.getString(1)%></option>
        <% } %>
        </select>
        <br><br><br><br><br><br><br><br>
        <input type="submit" style="width: 200px; height: 40px; font-size: 20px;" value="Next" onclick="window.location.href=/BTMS1/selectbus.jsp" /> <BR> <BR> <br>   
</center>
</form>
<%

        }
        catch(Exception e)
        {
             out.println("wrong entry"+e);
        }
%>

</BODY>
</HTML>