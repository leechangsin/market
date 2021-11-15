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
 * Servlet implementation class Chap6SessionAdd
 */
@WebServlet("/chap6/session/add")
public class Chap6SessionAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Chap6SessionAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String data = request.getParameter("data");
		
		// 조심! setAttribute 메서드의 두 번째 매개변수의 타입이 Object 이므로
		// Object 타입으로 형 변환되서 저장되는 것!!
		session.setAttribute("data", data);
		
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.print("<p>데이터 추가 / 추가한 데이터 = " + data +"</p>");
		
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
