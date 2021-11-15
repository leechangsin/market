package chapter3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex5
 */
@WebServlet("/ex5")
public class Ex5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex5() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		String name = request.getParameter("name");
		
		PrintWriter out = response.getWriter();
		
		// 이 서블릿에 접근한 컴퓨터의 IP 주소
		String clientIP = request.getRemoteAddr();
		String adminIP = "192.168.10.12";
		
		if(clientIP.equals(adminIP)) {
			out.print("<html>");
			out.print("<head>");
			out.print("		<title>ex</title>");
			out.print("</head>");
			out.print("<body>");
			
			try {
				int age = Integer.parseInt(request.getParameter("age"));
				
				if(name == null) {
					out.print("		<h1>name 파라미터를 넣어서 호출해야 합니다</h1>");
				} else {
					out.print("		<h1>클라이언트가 전달한 파라미터</h1>");
					out.print("		<p>name = " + name + " </p>");
					out.print("		<p>age = " + age + "</p>");
				}
			} catch(NumberFormatException e) {
				// age 파라미터를 넣어서 호출해야 합니다

				out.print("		<h1>age 파라미터를 넣어서 호출해야 합니다</h1>");
			} finally {
				out.print("</body>");
				out.print("</html>");
				
				// 스트림을 닫는 코드는 항상! finally 안에 넣어줘야함
				out.close();
			}
		} else {
			// 이 서블릿으로 접근한 컴퓨터가 내 컴퓨터가 아닐 때
			out.print("<h1>허용된 관리자만 접근할 수 있습니다.</h1>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
