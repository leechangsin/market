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
 * Servlet implementation class Chap6Ex9
 */
@WebServlet("/chap6/ex9")
public class Chap6Ex9 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Chap6Ex9() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 컨텍스트에 꼭 init 메서드로만 접근할 수 있는건 아니고
		// HttpServlet 부모 클래스가 제공하는 getSerlvetContext 메서드를 사용하면
		// doGet 메서드 안에서 컨텍스트에 직접 접근할 수 있음
		
		// 같은 애플리케이션 내 모든 서블릿이 같은 컨텍스트에 접근할 수 있으므로
		// 컨텍스트에 저장된 값은 모든 서블릿이 공용으로 사용하는 글로벌한(전역 단위의) 값이 됨
		ServletContext context = getServletContext();
		
		PrintWriter out = response.getWriter();
		
		// 컨텍스트를 활용하는 예
		out.print("Context = " + context + "\n");
		
		// web.xml에 등록한 컨텍스트의 값을 저장(context-param 태그)
		String shutDownTime = context.getInitParameter("shutDownTime");
		out.print("shut down time = " + shutDownTime);
		
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
