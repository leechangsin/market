package chapter3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex4
 */
@WebServlet("/ex4")
public class Ex4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex4() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<head>");
		out.print("		<title>ex</title>");
		out.print("</head>");
		out.print("<body>");
		
		// getParameter메서드는 해당 파라미터를 전달 받지 못했다면 null을 반환
		// name 파라미터의 값을 반환
		String name = request.getParameter("name");
		// age 파라미터의 값을 반환
		String age = request.getParameter("age");
		
		// 문자열로된 숫자 age 변수의 값을 정수로 바꿔서 나이에 맞는 태어난 연도를 계산해서 화면에 출력하세요.
		// 태어난 연도는 올해 - 나이 로 계산하면 됨
		int i_age = Integer.parseInt(age);
		int year = 2021 - i_age;
		
		out.print("name = " + name + "<br>");
		
		out.print("age = " + age + "<br>");
		
		out.print("year = " + year + "<br>");
		
		// 요청 정보의 헤더 -> 요청 정보와 관련된 설정 사항들이 위치
		// 헤더의 name들을 Enumeration 타입의 객체에 담아서 반환
//		Enumeration<String> headerNames = request.getHeaderNames();
//		while(headerNames.hasMoreElements()) {
//			String headerName = headerNames.nextElement();
//			String headerValue = request.getHeader(headerName);
//			
//			out.print("		<p>" + headerName + " = " + headerValue +"</p>");
//		}
		
//		out.print("		<h3>요청 방식과 프로토콜 정보</h3>");
//		
//		out.print("		<p>Request URL : " + request.getRequestURL() + "</p>");
//		out.print("		<p>Request URI : " + request.getRequestURI() + "</p>");
//		out.print("		<p>Request Protocol : " + request.getProtocol() + "</p>");
//		out.print("		<p>Context Path : " + request.getContextPath() + "</p>");
//		out.print("		<p>Servlete Path : " + request.getServletPath() + "</p>");
		
//		out.print("		<h3>네트워크 관련 요청 정보</h3>");
//		// getScheme() -> Client가 요청하기 위해서 사용한 프로토콜
//		out.print("		<p>Request Scheme : " + request.getScheme() + "</p>");
//		// getRemoteAddr() -> Client의 아이피 (인터넷 주소)
//		out.print("		<p>Client Address : " + request.getRemoteAddr() + " </p>");
//		// getRemotePort() -> Client의 포트
//		out.print("		<p>Client Port : " + request.getRemotePort() + " </p>");
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
