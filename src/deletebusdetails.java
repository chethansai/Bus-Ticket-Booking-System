

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class deletebusdetails
 */
@WebServlet("/deletebusdetails")
public class deletebusdetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deletebusdetails() {
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
       
        String busno=request.getParameter("bno");
        //String source=request.getParameter("src");
        //String dest=request.getParameter("dest");
        String bustable="";
		   bustable=bustable.concat("bus"+busno);
       
        
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        //String url="jdbc:mysql://localhost:3306/test";
        
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
        Statement st =conn.createStatement();
        Statement st1 =conn.createStatement();
        Statement st2 =conn.createStatement();
        String query="delete from bus_details where `busno`='"+busno+"' "; 
        String q="drop table "+bustable.trim()+"";
        st1.executeUpdate(q);
        String qu="delete from show_user where busno='"+busno+"'";
        st2.executeUpdate(qu);
        if(st.executeUpdate(query)>0){
            response.sendRedirect("busdetailsdeleted.html");
        }
        else out.println("sorry");
        }catch(Exception e){
        	e.printStackTrace();
            out.println("oops");
        }
        out.close();
		doGet(request, response);
	}

}
