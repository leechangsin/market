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
 * Servlet implementation class Chap6Ex5
 */
@WebServlet("/chap6/ex5")
public class Chap6Ex5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Chap6Ex5() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		// getSession() -> 해당 클라이언트의 세션이 없다면 세션을 만들고 반환 / 있다면 반환
		// 세션이 없다 -> 클라이언트가 세션 ID를 전달해주지 않았거나 세션의 유효 시간이 지나서 사라졌을 경우
		
		HttpSession session = request.getSession();
		
		// isNew() -> 세션이 막 만들어진건지 여부를 알 수 있음
		if(session.isNew()) {
			// 세션이 막 만들어졌다면
			out.print("create Session");
		} else {
			// 그렇지 않다면
			out.print("already exists Session");
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
