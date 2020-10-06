

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class userlogin
 */
@WebServlet("/userlogin")
public class userlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userlogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
        PrintWriter out=response.getWriter();
       
        String uid=request.getParameter("uid");
        String pass=request.getParameter("pass");
        
       
        //String url="jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",user="root",pwd="";
        String query="select `uid`,`pass` from `regtable` where `uid`='"+uid+"' and pass='"+pass+"'";
       
       
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
        Statement stmt=conn.createStatement();
        stmt.executeQuery(query);
        ResultSet rs=stmt.executeQuery(query);
        while(rs.next()){
            if(rs.getString(2).equals(pass)){
                //RequestDispatcher rd=request.getRequestDispatcher("userhome.html");
                //rd.forward(request,response);
            	request.getSession().setAttribute("uid",uid);
            	request.getRequestDispatcher("userlogin.jsp").include(request,response);
                //response.sendRedirect("userhome.html");
            }
            else{
                //RequestDispatcher rd=request.getRequestDispatcher("register.html");
                //rd.forward(request,response);
            	request.getRequestDispatcher("adminloginerror.html").include(request,response);
                //response.sendRedirect("adminloginerror.html");
                }
           
        }
       
       
        }catch(Exception e){}
       
        out.close();
		doGet(request, response);
	}

}
