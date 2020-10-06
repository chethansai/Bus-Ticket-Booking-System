<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.sql.*" %>
<%ResultSet resultset =null;%>
<!DOCTYPE html>
<HTML>
<HEAD>
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
    <TITLE>Select element drop down box</TITLE>
</HEAD>

<BODY >
<% 
String name=(String)session.getAttribute("uid"); 
System.out.println("Hello User: You have entered the name: "+name);

%>
<%
//String source = request.getParameter("source");
//String dest = request.getParameter("dest");
//System.out.println(source);
//System.out.println(dest);
    try{
//Class.forName("com.mysql.jdbc.Driver").newInstance();
Class.forName("com.mysql.cj.jdbc.Driver");
//String url="jdbc:mysql://localhost:3306/test";
String b=request.getParameter("busdrop");
String bustable="";
bustable=bustable.concat("bus"+b);

Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");

       Statement statement = connection.createStatement() ;
       String query="select seatno from "+bustable.trim()+" where uid='"+name+"'" ;
       ResultSet rs =statement.executeQuery(query);
       //String dest = rs.getString("destval");
       //String bnum=(String)request.getAttribute("bus");
       
%>
<form method="post" action="/BTMS1/cancelseat">
<center><br><br><br>
    <h1 style="color: white; font-size: 40px;"> <i>SELECT SEAT TO BE CANCELLED</i></h1><br><br><br>
        <label style="font-size: 30px;"><b><i>Seat Numbers: </i></b></label><select name="busdrop" style="width:400px; height:25px; font-size:20px;">
        <%  while(rs.next()){ %>
            <option value="<%=rs.getString(1)%> ">Seat No:<%= rs.getString(1)%></option>
        <% } %>
        </select><br><br><br>
        
        
        
  <input type="submit" style="width: 100px; height: 30px; font-size: 20px;" value="CANCEL" onclick="window.location.href=/BTMS1/cancelseat.java" >
</center></form>

<%
//**Should I input the codes here?**
        }
        catch(Exception e)
        {
             out.println("wrong entry"+e);
        }
%>

</BODY>
</HTML>