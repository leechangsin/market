package chapter6;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// 로그인 성공 처리 서블릿
@WebServlet("/chap6/login/step4")
public class Chap6LoginStep4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 성공 처리 코드
		
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		// 세션에 로그인 성공! 기록
		HttpSession session = request.getSession();
		if(session.isNew() || session.getAttribute("isLogin") == null) {
			session.setAttribute("isLogin", true);
			
			// 로그인 되었습니다 안내 (일반적으로는 200 상태코드만 응답)
			out.print("로그인 되었습니다");
		} else {
			// 현재 로그인 되어있는 상태입니다 안내 (일반적으로는 상태코드로 응답을하는게 가장 좋은 프로그램)
			out.print("현재 로그인 되어있는 상태입니다");
			response.setStatus(208);
		}
		
		// 결과를 response
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
