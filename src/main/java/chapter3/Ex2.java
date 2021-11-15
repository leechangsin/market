package chapter3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex2
 */
@WebServlet("/ex2")
public class Ex2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex2() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트가 요청한 결과를 만들어낸다.
		// 서블릿에서 DB나 자바 등을 활용
		// 서블릿에서 결과를 만들면 결과에 맞는 페이지를 response
		
		// 클라이언트가 요청한 결과에 맞게 페이지를 구성해서 응답한다.
		// HTML, CSS, JS / JSP 를 활용
		
		// sendRedirect() -> 지정한 경로로 이동해 라고 클라이언트에게 명령을 내리는 응답
		// 경로는 /부터 시작하고 경로의 맨 앞에 http://서버주소:포트번호 가 생략된 상태
		// 이 응답을 하게되면 클라이언트의 브라우저 URL도 같이 바뀌는 특징
		response.sendRedirect("/Market/chapter3/rainbow.html");
		
		// 이 아래 있는 코드는 전부 주석 처리
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}





