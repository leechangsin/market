package chapter3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex3
 */
@WebServlet("/ex3")
public class Ex3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex3() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 상태코드를 별도로 설정하지 않으면 서버의 기본 설정을 따라서 상태 코드를 보냄
		// 우리 서버(톰캣)의 기본 설정은 상태 코드를 200으로 설정하도록 되어있음
		// sendRedirect와 동일한 동작
		response.setStatus(301);
		response.setHeader("Location", "http://192.168.10.12:80/Market/ex2");
		
		// sendRedirect나 301 상태 코드로 응답하면 그 밑에 있는 코드는 의미가 없어짐
//		response.setContentType("text/plain;charset=UTF-8");
//		
//		PrintWriter out = response.getWriter();
//		
//		out.print("ex3으로 접근했습니다!!");
//		
//		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
