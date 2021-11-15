package chapter6;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Chap6Ex8
 */
@WebServlet("/chap6/ex8")
public class Chap6Ex8 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ServletContext context;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메서드 호출");
		
		// 컨텍스트는 init 메서드의 ServletConfig 객체를 통해서 접근할 수 있음
		// 사용자의 요청을 처리하는 doGet 메서드에서 컨텍스트를 활용하기 위해서
		// 멤버 변수에 저장하고 있음
		context = config.getServletContext();
		
		System.out.println("ServletContext 저장");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		// init 메서드에서 멤버 변수에 저장해준 컨텍스트를 활용하는 예
		out.print("Context = " + context);
		
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
