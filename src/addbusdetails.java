

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
 * Servlet implementation class addbusdetails
 */
@WebServlet("/addbusdetails")
public class addbusdetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addbusdetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//System.out.println("okayyyyy");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
        PrintWriter out=response.getWriter();
       
        String bno=request.getParameter("bno");
        String src=request.getParameter("src");
        String dest=request.getParameter("dest");
        String dept=request.getParameter("dept");
        String seats=request.getParameter("seats");
        String price=request.getParameter("price");
        Integer seat=Integer.parseInt(seats);
        //request.getSession().setAttribute("totalseats",seats);
       
        
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        //String url="jdbc:mysql://localhost:3306/test";
        
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
        Statement st =conn.createStatement();
        Statement stmt =conn.createStatement();
        Statement stmt1 =conn.createStatement();
        String bustable="";
        bustable=bustable.concat("bus"+bno);
		String query1="create table "+bustable.trim()+"(uid varchar(20),username varchar(20),seatno varchar(20),status varchar(20))";
		stmt.executeUpdate(query1);
		int k=1;
		while(k<=seat) {
			String query2="insert into "+bustable.trim()+"(seatno,status) values ('"+k+"','"+0+"')";
			k++;
			stmt1.executeUpdate(query2);
		}
        String query="insert into bus_details values ('"+bno+"','"+src+"','"+dest+"','"+dept+"','"+seats+"','"+price+"')";
        if(st.executeUpdate(query)>0){
            response.sendRedirect("busdetailsadded.html");
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
