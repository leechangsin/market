package chapter6;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 로그인 요청을 최초로 받는 서블릿이자 파라미터를 확인하는 서블릿
@WebServlet("/chap6/login/step1")
public class Chap6LoginStep1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파라미터를 확인하는 코드
		
		String userId = request.getParameter("id");
		String userPw = request.getParameter("pw");
		
		if(userId != null && userPw != null) {
			// String 타입의 객체를 통해서 trim 메서드를 호출 할 수 있음
			// trim메서드는 문자열의 앞, 뒤 공백을 제거해주는 메서드
			userId = userId.trim();
			userPw = userPw.trim();
		}
		
		if( (userId == null || userPw == null) || (userId.isEmpty() || userPw.isEmpty()) ) {
			// 로그인에 필요한 파라미터를 전달하지 않았다면
			// BAD_REQEUST 응답
			
			// response.setStatus(400);
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			
			response.setContentType("text/html;charset=UTF-8");
			
			PrintWriter out = response.getWriter();
			
			out.print("브라우저의 뒤로가기 버튼을 눌러 ID 또는 PW를 입력하세요");
			
			out.close();
			
			return ;
		}
		
		// 로그인에 필요한 파라미터를 전달했다면
		// 다음 서블릿으로 forward
		RequestDispatcher rd = request.getRequestDispatcher("/chap6/login/step2");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
