package chapter1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Chap1Ex1
 */
@WebServlet("/chapter2/ex1")
public class Chap1Ex1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Chap1Ex1() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		Enumeration<String> headerNames = request.getHeaderNames();
		
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<head>");
		out.print("<title>ex</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("		<h3>헤더 정보</h3>");
		
		while(headerNames.hasMoreElements()) {
			String headerName = headerNames.nextElement();
			String headerValue = request.getHeader(headerName);
			
			out.print("<p>" + headerName + " = " + headerValue +"</p>");
		}
		
		out.print("</body>");
		out.print("</html>");
		
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
