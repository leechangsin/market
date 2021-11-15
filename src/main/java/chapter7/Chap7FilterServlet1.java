package chapter7;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/chap7/filter/servlet1")
public class Chap7FilterServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("<< servlet1 호출 >>");
		
		PrintWriter out = response.getWriter();
		
		out.print("		<h1>여기는 Servlet1 입니다.</h1>");
		out.print("		<p>공통적으로 입력해야하는 서블릿의 동작에는 영향을 미치지 않는 코드는 필터에 두었음</p>");
		
		// 필터에서 html의 나머지 태그들을 출력하고 있는 구조이므로
		// 서블릿에서 output stream을 닫으면 안됨
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
