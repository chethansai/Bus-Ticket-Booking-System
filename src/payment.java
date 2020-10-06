

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class payment
 */
@WebServlet("/payment")
public class payment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public payment() {
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
		String bno = (String)request.getSession(false).getAttribute("bus");
		String uname=(String)request.getSession(false).getAttribute("user");
		String uid=(String)request.getSession(false).getAttribute("uid");
		String s1=(String)request.getSession(false).getAttribute("seats");
		String[] s=s1.split(",");
		    try{

		Class.forName("com.mysql.cj.jdbc.Driver");
		//String url="jdbc:mysql://localhost:3306/test";

		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");

		       Statement stmt = connection.createStatement() ;
		       Statement stmt5 = connection.createStatement() ;
		       Statement stmt6 = connection.createStatement() ;
		       Statement stmt7 = connection.createStatement() ;
		       PrintWriter out=response.getWriter();
		      
		       String bustable="";
		    		   bustable=bustable.concat("bus"+bno);
		       
		    			int k=0;
		    	for(int i=0;i<s.length;i++)
		    	{
		    		String query2="select * from "+bustable.trim()+" where seatno='"+s[i]+"'";
		    		//System.out.println("q2----- "+query2);
		    		//String query3 =query2.replace("$tableName",bno);
		    		//Statement stmt2 =connection.createStatement();
		    		//stmt2.executeQuery(query3);
		    		ResultSet rs= stmt.executeQuery(query2);
		    		System.out.println(rs);
		 
		    		if(rs.next()){
		    			int sts=Integer.parseInt(rs.getString("status"));
		    		if(sts==1)
		    		{
		    			//response.sendRedirect("error.html");
		    			//out.println("seat "+s[i]+"is booked");
		    			//out.println("Go back and select another Seats");
		    			   out.println("<script type=\"text/javascript\">");
		    			   out.println("alert('seat "+s[i]+"is not available');");
		    			   //out.println("location='selectbus.jsp';");
		    			   out.println("</script>");
		    			  
		    			//System.out.println("seat "+s[i]+"is booked");
		    			k=1;
		    			
		    			
		    		}
		    		else continue;
		    	} }if(k==1)out.println("<html><head><style>\r\n" + 
		    			"body{\r\n" + 
		    			"  background-image:url('bus.jpg');\r\n" + 
		    			"  height:\"100\";\r\n" + 
		    			"  width:\"100\";\r\n" + 
		    			"  background-position: center;\r\n" + 
		    			"  background-repeat: no-repeat;\r\n" + 
		    			"  background-size: cover;\r\n" + 
		    			"}\r\n" + 
		    			"</style></head><body><a href=\"selectsrcdest.jsp\"><h1 style=\"color: white; font-size: 40px;\"><i>Go back and select another Seats</i></a></h1></body></html>");
		    	if(k==0)
		    	{
		    		for(int i=0;i<s.length;i++)
		    		{
		    			String query="UPDATE "+bustable.trim()+" SET uid='"+uid+"',username='"+uname+"',status='"+1+"' where seatno='"+s[i]+"'";
		    			//System.out.println(query);
		    			stmt.executeUpdate(query);
		    			
		    			
		    			
		    		}
		    		String q1="select source,dest from bus_details where busno='"+bno+"'";
		    		//String qu="select * from show_user where busno='"+bno+"' and uid='"+uid+"'";
		    		//ResultSet rs2=stmt7.executeQuery(qu);
		    		ResultSet rs1=stmt6.executeQuery(q1);
		    		
		    		if(rs1.next()) {
		    	    
		    		
		    		String q="insert into show_user values ('"+uid+"','"+bno+"','"+rs1.getString(1)+"','"+rs1.getString(2)+"','"+uname+"')";
		    		stmt5.executeUpdate(q);
		    		}
		    		response.sendRedirect("end.html");
		    	}
		    	
		    		//response.sendRedirect("selectbus.jsp");
		    	
		    }catch(Exception e)
		    {
		        System.out.println("wrong entry"+e);
		   }
		doGet(request, response);
	}

}
