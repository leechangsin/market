package chapter6;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 회원 정보를 조회하는 서블릿
@WebServlet("/chap6/login/step2")
public class Chap6LoginStep2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원 정보를 조회하는 코드
		
		// 아이디를 사용해서 회원 정보 조회
		String userId = request.getParameter("id");
		
		// 일반적으로 회원 정보 조회 동작은 Database와 연동을 해서
		// DB에서 userId와 일치하는 회원 정보를 가져오는 코드를 넣게 됨
		// 우리는 아직 DB를 배우지 않았으니까 주석으로 대체
		// 회원 정보를
		// 이렇게
		// 저렇게
		// 조회했다
		
		// 회원 정보 조회 성공 여부 / true -> 아이디와 일치하는 회원 정보 있음 / false -> 일치하는 회원 정보 없음
		boolean exist = true;
		if(!exist) {
			// 회원 정보가 조회되지 않았다면
			// BAD_REQEUST 응답
			
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			
			response.setContentType("text/html;charset=UTF-8");
			
			PrintWriter out = response.getWriter();
			
			out.print("브라우저의 뒤로가기 버튼을 눌러 ID 또는 PW를 확인하세요.");
			
			out.close();
			
			return ;
		}
		
		// 회원 정보가 조회 됬다면
		// 다음 서블릿으로 forward
		
		// 조회된 회원 ID
		String memberId = "id";
		// 조회된 회원 PW
		String memberPw = "1234";
		
		request.setAttribute("memberId", memberId);
		request.setAttribute("memberPw", memberPw);
		
		RequestDispatcher rd = request.getRequestDispatcher("/chap6/login/step3");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
