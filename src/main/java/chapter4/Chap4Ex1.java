package chapter4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Chap4Ex1
 */
@WebServlet("/chap4/ex1")
public class Chap4Ex1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Chap4Ex1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		
		// getParameterValues() -> hobby 이름으로 여러 값이 담겨올 수 있으므로 이 메서드를 써야지만
		//                         해당 이름에 담겨 있는 여러 개의 값을 꺼낼 수 있음
		String[] hobbys = request.getParameterValues("hobby");
		
		String gender = request.getParameter("gender");
		String religion = request.getParameter("religion");
		String intro = request.getParameter("intro");
		
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.print("ID : " + id + "<br>");
		out.print("PW : " + pw + "<br>");
		out.print("이름 : " + name + "<br>");
		
		out.print("취미 : ");
		for(String hobby : hobbys) {
			out.print(hobby + " ");
		}
		out.print("<br>");
		
		out.print("성별 : " + gender + "<br>");
		out.print("종교 : " + religion + "<br>");
		out.print("자기소개 : " + intro + "<br>");
		
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		doGet(request, response);
	}

}
