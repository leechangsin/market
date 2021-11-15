package chapter6;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Chap6Ex3
 */
@WebServlet("/chap6/ex3")
public class Chap6Ex3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Chap6Ex3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트별로 방문 횟수를 체크하는 서비스
		
		// 이 서블릿으로 접근한 클라이언트의 쿠키 중, 방문 횟수를 체크하는 쿠키
		Cookie targetCookie = null;
		// 이 서블릿으로 최초로 접근을 했다면 또는 쿠키가 없는 상태라면 방문 횟수를 체크하는 쿠키가 없으므로
		// count = 1로 설정해서 기본 방문 횟수를 1회로 설정
		int count = 1;
		
		Cookie[] cookieList = request.getCookies();
		
		for(Cookie cookie : cookieList) {
			// n번째 쿠키의 이름
			String name = cookie.getName();
			
			if(name.equals("count")) {
				// n번째 쿠키가 count 라면
				
				// n번째 쿠키를 targetCookie로 지정
				targetCookie = cookie;
				
				// targetCookie.getValue() -> 쿠키에 저장된 값을 가져올 수 있음
				count = Integer.parseInt( targetCookie.getValue() );
				// 방문 횟수를 하나 증가
				count++;
				
				// String.valueOf() -> 대상을 문자열화 해주는 메서드
				targetCookie.setValue( String.valueOf(count) );
			}
		}
		
		if(targetCookie == null) {
			targetCookie = new Cookie("count", String.valueOf(count));
			targetCookie.setMaxAge(60 * 60 * 24);
		}
		
		response.addCookie(targetCookie);
		
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();

		out.print("<h1>방문 횟수 : " + count +  "</h1>");
		
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
