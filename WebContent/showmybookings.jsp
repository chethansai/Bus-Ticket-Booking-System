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

Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");

       Statement statement = connection.createStatement() ;
       String query="select distinct busno,source,dest from show_user where uid='"+name+"'" ;
       ResultSet rs =statement.executeQuery(query);
       //String dest = rs.getString("destval");
       
%>
<form method="post" action="/BTMS1/showmybookings">
<center><br><br><br>
    <h1 style="color: white; font-size: 40px;"> <i>SELECT YOUR BUS DETAILS</i></h1><br><br><br>
        <label style="font-size: 30px;"><b><i>Details: </i></b></label><select name="busdrop" style="width:400px; height:25px; font-size:20px;">
        <%  while(rs.next()){ %>
            <option value="<%=rs.getString(1)%> ">Bus No:<%= rs.getString(1)%>-Source:<%= rs.getString(2)%>-Destination:<%= rs.getString(3)%></option>
        <% } %>
        </select><br><br><br>
        
        
        
  <input type="submit" style="width: 100px; height: 30px; font-size: 20px;" value="Submit" onclick="window.location.href=/BTMS1/showbookingdetails.java" >
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