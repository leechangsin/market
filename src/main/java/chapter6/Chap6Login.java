package chapter6;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Chap6Login
 */
@WebServlet("/chap6/login")
public class Chap6Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Chap6Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("id");
		String userPw = request.getParameter("pw");
		
		String id = "id";
		String pw = "pw";
		
		response.setContentType("text/plain;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		// isEmpty() -> 변수에 들어있는 문자열의 길이가 0일 때 true를 0이 아닐 때 false를 반환
		if( (userId == null || userId.isEmpty()) || (userPw == null || userPw.isEmpty())) {
			out.print("브라우저의 뒤로가기 버튼을 눌러 ID 또는 PW를 입력하세요.");
			
			// 반환타입이 void인 메서드의 동작을 중간에 끝내고 싶을 때 아래와 같이 return을 활용
			return ;
		} else if(!userId.equals(id) || !userPw.equals(pw)) {
			out.print("아이디 또는 비밀번호를 확인하세요.");
			
			return ;
		}
		
		// 정확한 아이디와 비밀번호를 입력했을 경우
		
		HttpSession session = request.getSession();
		if(session.isNew() || session.getAttribute("isLogin") == null) {
			session.setAttribute("isLogin", true);
			
			out.print("로그인되었습니다");
		} else {
			out.print("현재 로그인 되어있는 상태입니다");
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
