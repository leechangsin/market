package chapter3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex1
 */
@WebServlet("/ex1")
public class Ex1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 항상 응답을 하기전! 에
		// 클라이언트에게 전달해야할 데이터가 있다면
		// 꼭 setContentType 메서드를 사용해서
		// 우리가 전달하는 데이터가 어떤 타입인지 명시를 해줘야함!
		// 데이터가 어떤 타입인지 명시를 할 때는 MIME TYPE 으로 명시
		// 그 다음 전달하는 데이터에 영문 이외의 문자가 들어있다면
		// 그 문자를 인식할 수 있는 인코딩 방법을 명시해줘야함!
		response.setContentType("text/html;charset=UTF-8");
		
		// PrintWriter -> 클라이언트와 연결된 Output stream
		PrintWriter outputstream = response.getWriter();

		outputstream.print("<html>");
		outputstream.print("<head>");
		outputstream.print("	<title>servlet response</title>");
		outputstream.print("</head>");
		outputstream.print("<body>");
		outputstream.print("	<h1>Nice to meet you!</h1>");
		outputstream.print("	<h1>만나서 반갑습니다!</h1>");
		outputstream.print("</body>");
		outputstream.print("</html>");
		
		outputstream.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
