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
 * Servlet implementation class Chap6Ex2
 */
@WebServlet("/chap6/ex2")
public class Chap6Ex2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Chap6Ex2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트가 전달한 쿠키를 꺼내서 사용하는 코드들...
		
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		Cookie[] cookieList = request.getCookies();
		
		try {
			for(Cookie cookie : cookieList) {
				String cookieName = cookie.getName();
				String cookieValue = cookie.getValue();
				
				out.print("cookieName = " + cookieName + "<br>");
				out.print("cookieValue = " + cookieValue + "<br>");
				out.print("<hr>");
			}
		} catch(NullPointerException e) {
			out.print("쿠키가 존재하지 않습니다.");
		}
		
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
