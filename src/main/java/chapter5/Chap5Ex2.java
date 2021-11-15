package chapter5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Chap5Ex2
 */
@WebServlet("/chap5/ex2")
public class Chap5Ex2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String name;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Chap5Ex2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

//		String name = request.getParameter("name");
		name = request.getParameter("name");
		
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<head>");
		out.print("		<title>ex</title>");
		out.print("</head>");
		out.print("<body>");
		
		out.print("		<h2> << 처리 결과 >> </h2>");
		for(int i=1; i<=5; i++) {
			out.print("		<p>" + i + "</p>");
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		out.print(name + "님의 요청을 처리하였습니다");
		
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
