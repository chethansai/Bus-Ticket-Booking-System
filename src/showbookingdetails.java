

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class showbookingdetails
 */
@WebServlet("/showbookingdetails")
public class showbookingdetails extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showbookingdetails() {
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
		PrintWriter out = response.getWriter();
		out.println("<html><head><style>\r\n" + 
				"body{\r\n" + 
				"  background-image:url('bus.jpg');\r\n" + 
				"  height:\"100\";\r\n" + 
				"  width:\"100\";\r\n" + 
				"  background-position: center;\r\n" + 
				"  background-repeat: no-repeat;\r\n" + 
				"  background-size: cover;\r\n" + 
				"}\r\n" + 
				"</style></head></html>");
		  
        response.setContentType("text/html");  
        //out.println("<html><body>");  
        //String query="select * from bus_details";
        try 
        {  
        	Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
            String b=request.getParameter("busdrop");
            String bustable="";
 		   bustable=bustable.concat("bus"+b);
            PreparedStatement stmt = conn.prepareStatement("select * from "+bustable.trim()+" where status='"+1+"'"); 
            //stmt.executeQuery("query");
            ResultSet rs = stmt.executeQuery();  
            //out.println("<table border=1 width=50% height=50%>");  
            out.println("<html><body><center><table border=1 width=100><tr><td>User Name</td><td>Passenger Name</td><td>Seat Number</td><tr>");  
            while (rs.next()) 
            {  
                String busno = rs.getString(1);  
                String source = rs.getString(2);  
                String dest = rs.getString(3); 
                //String dept = rs.getString(4);
                //String seats = rs.getString("seats");
                //String price = rs.getString("price");
                out.println("<tr><td>" + busno + "</td><td>" + source + "</td><td>" + dest + "</td></tr>");   
            }  
            out.println("</table></center></body></html>");  
            //out.println("</body></html>");  
            conn.close();  
           }  
            catch (Exception e) 
           {  
            out.println("error");  
        } 
		doGet(request, response);
	}

}
