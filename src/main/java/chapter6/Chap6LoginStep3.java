package chapter6;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 비밀번호를 확인하는 서블릿
@WebServlet("/chap6/login/step3")
public class Chap6LoginStep3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 비밀번호를 확인하는 코드

		String userPw = request.getParameter("pw");
		String memberPw = (String) request.getAttribute("memberPw");
		
		if(!userPw.equals(memberPw)) {
			// 비밀번호가 일치하지 않는다면
			// BAD_REQEUST 응답
			
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			
			response.setContentType("text/html;charset=UTF-8");
			
			PrintWriter out = response.getWriter();
			
			out.print("브라우저의 뒤로가기 버튼을 눌러 ID 또는 PW를 확인하세요.");
			
			out.close();
			
			return ;
		}
		
		// 아이디로 조회한 회원 정보의 비밀번호와 클라이언트가 전달한 비밀번호가 일치한다면
		// 다음 서블릿으로 forward
		RequestDispatcher rd = request.getRequestDispatcher("/chap6/login/step4");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
