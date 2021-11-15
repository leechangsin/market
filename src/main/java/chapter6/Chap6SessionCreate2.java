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
 * Servlet implementation class Chap6SessionCreate
 */
@WebServlet("/chap6/session/create2")
public class Chap6SessionCreate2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Chap6SessionCreate2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		// 이 클라이언트의 세션이 만들어져있으면
		// 만들어진 세션을 반환
		// 만들어져 있지 않거나 유효기간이 지난 세션이면 새롭게 만들어서 반환
		HttpSession session = request.getSession();
		
		if(session == null) {
			// 이 클라이언트의 세션을 가져오지 못했을 경우
			out.print("<p>세션 없음</p>");
		} else {
			// 이 클라이언트의 세션을 가져왔을 경우
			out.print("<p>세션 있음</p>");
			
			if(session.isNew()) {
				out.print("<p>세션이 새로 만들어짐</p>");
				
				// 세션이 만들어질 때 유지 시간을 설정하지 않으면 30분으로 설정됨
				// 유지 시간을 설정하면 그 시간만큼만 살아있다가 그 시간이 지나면 사라짐
				// 유지 시간은 절대 시간이 아니라 클라이언트가 마지막으로 접속한 시간으로부터 카운팅이 됨
				session.setMaxInactiveInterval(10800);
			} else {
				out.print("<p>기존에 만들어졌던 세션임</p>");
			}
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
