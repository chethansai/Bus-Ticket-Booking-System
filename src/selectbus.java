

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
 * Servlet implementation class selectbus
 */
@WebServlet("/selectbus")
public class selectbus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public selectbus() {
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

		String s=request.getParameter("source");
		String d=request.getParameter("dest");

		//Class.forName("com.mysql.cj.jdbc.Driver");
		//String url="jdbc:mysql://localhost:3306/test";

		//Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");

		   //    Statement statement = connection.createStatement() ;

		   //    ResultSet rs=statement.executeQuery("select * from bus_details where source='"+s+"' and destination='"+d+"'") ;

		//out.println("<html><body><form method="post" action=""><select name="buses">");
		//while(rs.next())
		{
		//int bno=Integer.parseInt(rs.getString("busno"));
		//out.println("<option value="bno">bno</option>");
		}
		doGet(request, response);
	}

}
