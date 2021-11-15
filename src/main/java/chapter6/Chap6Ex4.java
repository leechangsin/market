package chapter6;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Chap6Ex4
 */
@WebServlet("/chap6/ex4")
public class Chap6Ex4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Chap6Ex4() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookieList = request.getCookies();
		
		for(Cookie cookie : cookieList) {
			String name = cookie.getName();
			
			if(name.equals("count")) {
				// n번째 쿠키의 이름이 count 라면
				
				// 해당 쿠키의 유효시간을 0으로 설정
				// ( 해당 쿠키를 삭제하겠다 라는 의미 )
				cookie.setMaxAge(0);
				
				// 설정을 변경한 쿠키를 클라이언트에게 전달해
				// 해당 쿠키를 최신화 시킴
				response.addCookie(cookie);
			}
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
