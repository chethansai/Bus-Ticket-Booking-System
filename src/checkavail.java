

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.sun.tools.javac.jvm.StringConcat;

/**
 * Servlet implementation class checkavail
 */
@WebServlet("/checkavail")
public class checkavail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkavail() {
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
		String bno = request.getParameter("busdrop");
		String uname=request.getParameter("uname");
		//String uid=(String)request.getSession(false).getAttribute("uid");
		String s=request.getParameter("seats");
		String[] s1=s.split(",");
		Integer slen=s1.length;
		request.getSession().setAttribute("user",uname);
		request.getSession().setAttribute("bus",bno);
		request.getSession().setAttribute("seats",s);
		
		try{

			Class.forName("com.mysql.cj.jdbc.Driver");
			//String url="jdbc:mysql://localhost:3306/test";

			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");

			       Statement stmt = connection.createStatement() ;
			       PrintWriter out=response.getWriter();
			       String query="select price from bus_details where busno='"+bno+"'";
			       ResultSet rs=stmt.executeQuery(query);
			       if(rs.next()){
			    	   out.println("<script type=\"text/javascript\">");
			    	   Integer i=slen*Integer.parseInt(rs.getString(1));
	    			   out.println("alert('Total Price is:"+i+"');");
	    			   //out.println("location='selectbus.jsp';");
	    			   out.println("</script>");
			       }}
			       catch(Exception e)
				    {
				        System.out.println("wrong entry"+e);
				   }//response.sendRedirect("payment.html");
		PrintWriter out=response.getWriter();
		out.println("<html><head><style>\r\n" + 
    			"body{\r\n" + 
    			"  background-image:url('bus.jpg');\r\n" + 
    			"  height:\"100\";\r\n" + 
    			"  width:\"100\";\r\n" + 
    			"  background-position: center;\r\n" + 
    			"  background-repeat: no-repeat;\r\n" + 
    			"  background-size: cover;\r\n" + 
    			"}\r\n" + 
    			"</style></head><body><a href=\"payment.html\"><h1 style=\"color: white; font-size: 40px;\"><i>PROCEED TO PAYMENT</i></a></h1></body></html>");
		doGet(request, response);
	}

}
