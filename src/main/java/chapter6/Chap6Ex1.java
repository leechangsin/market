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
 * Servlet implementation class Chap6Ex1
 */
@WebServlet("/chap6/ex1")
public class Chap6Ex1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Chap6Ex1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 쿠키는 서버에서 만듬
		// 왜 ? 서버에서 클라이언트의 상태 정보가 필요하니까
		
		// 서버가 쿠키를 만들어 클라이언트로 전달하면
		// 클라이언트는 전달 받은 쿠키를 저장함
		//
		// 클라이언트가 쿠키를 갖고 있다면 어떤 요청이든
		// 요청할 때마다 요청 정보에 쿠키를 담아서 보냄
		//
		// 특정 경로에 있는 서버에게만 쿠키를 보내고 싶을 때
		// setPath 메서드를 사용
		Cookie c1 = new Cookie("id", "quest");
		c1.setPath("/");
		// Cookie는 클라이언트가 보관하는것이기 때문에 반드시!
		// 쿠키를 생성했거나 쿠키의 설정을 바꿨으면 addCookie 메서드를 사용해서
		// 클라이언트에게 전달해줘야함
		response.addCookie(c1);
		
		// 쿠키는 꼭 하나만 있어야하는건 아니고
		// name=value 형식의 저장소가 생기는것
		//
		// 클라이언트가 쿠키를 갖고 있으면 쿠키를 만든 서버내
		// 어떤 서비스든 모두 보내게 됨
		// 
		// 규모가 큰 프로젝트의 경우에는 여러 서버가 서로 하나의 프로젝트로 연계되서 동작
		// setDomain 메서드를 사용하면 쿠키를 전달할 서버를 지정
		// 
		// 예를들어 www.domain.com 을 인자로 넣으면 이 쿠키는 www.domain.com 서버로
		// 요청했을 때만 전달됨
		// .domain.com 을 인자로 넣으면 이 쿠키는 it.domain.com / array.domain.com 처럼
		// .domain.com 이 포함된 주소를 갖고 있는 서버로 요청할 때 전달 됨
		Cookie c2 = new Cookie("isLogin", "true");
		c2.setDomain("192.168.10.12");
		response.addCookie(c2);
		
		// 일반적으로는 아래와 같은 형태로 쿠키를 만들고 유지시간만 설정
		Cookie c3 = new Cookie("age", "20s");
		c3.setMaxAge(2592000);
		response.addCookie(c3);
		
		PrintWriter out = response.getWriter();
		
		out.print("done!");
		
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
