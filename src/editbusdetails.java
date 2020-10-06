

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class editbusdetails
 */
@WebServlet("/editbusdetails")
public class editbusdetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editbusdetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//System.out.println("okayy");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();  
		response.setContentType("text/html");
		Enumeration en=request.getParameterNames();
		Integer bno=Integer.parseInt(request.getParameter("busno"));
		try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
        Statement stmt=conn.createStatement();
        
        while(en.hasMoreElements())
        {
           String val=(String)en.nextElement();
           //System.out.println(val);
           String val1=request.getParameter(val);
           
           //System.out.println(val1);
           

        if(val1!="" && val!="busno")
       {
        String query="UPDATE bus_details SET "+val+"='"+val1+"' WHERE busno= '"+bno+"' ";
       stmt.executeUpdate(query);
        //ResultSet rs=stmt.executeQuery(query);
        
        }
        else {
        	continue;
        }
        
       
       
        }response.sendRedirect("busdetailsedited.html");
		}catch(Exception e){
			e.printStackTrace();
		}
      
        out.close();
		
		doGet(request, response);
	}

}
