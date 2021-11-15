package chapter6;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Chap6ContextGet
 */
@WebServlet("/chap6/context/get")
public class Chap6ContextGet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Chap6ContextGet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		ServletContext context = getServletContext();
		
		// session과 마찬가지로 값이 Object 타입의 객체로 저장되므로
		// 꺼낼 데이터의 원래 타입을 정확히 알아야지 꺼내서 쓸 수 있음
		ShareObject so = (ShareObject) context.getAttribute(id);
		
		PrintWriter out = response.getWriter();
		
		out.print("count = " + so.getCount() + "\n");
		out.print("str = " + so.getStr() + "\n");
		
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
