

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
 * Servlet implementation class regServ1
 */
@WebServlet("/regServ1")
public class regServ1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public regServ1() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
        
               
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
        PrintWriter out=response.getWriter();
       
        String fname1=request.getParameter("fname");
        String lname1=request.getParameter("lname");
        String mno1=request.getParameter("mno");
        String email1=request.getParameter("email");
        String uid1=request.getParameter("uid");
        String pass1=request.getParameter("pwd");
       
        
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        //String url="jdbc:mysql://localhost:3306/test";
        
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
        Statement st =conn.createStatement();
        String query="insert into regtable values ('"+fname1+"','"+lname1+"','"+mno1+"','"+email1+"','"+uid1+"','"+pass1+"')";
        if(st.executeUpdate(query)>0){
            response.sendRedirect("regs.html");
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
