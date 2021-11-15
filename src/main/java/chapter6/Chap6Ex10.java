package chapter6;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/chap6/ex10")
public class Chap6Ex10 extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// forward 메서드를 사용하면 제어가 완전히 다른 서블릿, JSP로 넘어가기 때문에
		// 이 서블릿에서 아래의 output stream으로 결과를 response를 하는건 무시됨(의미가 없음)
		// 무시된다는걸 확인하기 위해서 입력한 코드임
		// 그러나 여기서 output stream을 사용하고 있기 때문에
		// 반드시 close / output stream을 닫아줘야함
		// output stream을 닫는 시점은 forward 메서드를 호출하고난 다음에 닫아줘야함
		response.setContentType("text/plain;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.print("<< 첫 번째 서블릿의 실행 결과 >>");
		
		RequestDispatcher rd = request.getRequestDispatcher("/chap6/ex11");
		
		rd.forward(request, response);
		
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
