package chapter2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/second", name="two")
public class Second extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("second 서블릿의 doGet() 메서드 호출!");
	}
	
//	@Override
//	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
//		// 클라이언트가 어떤 방식으로 요청하더라도 service 메서드가 호출됨
//		// 클라이언트가 GET 방식으로 요청했다는건 컨텐츠를 전달 받기만 하기 위함이고
//		// 클라이언트가 POST 방식으로 요청했다는건 컨텐츠를 생성하기 위함임
//		// 이렇게 요청 방식에 따라서 클라이언트의 요청 사항이 다름
//		// service 메서드 하나만으로는 모든 요청을 처리하기에는 너무 불편하니까
//		// 실제로 개발할 때는 service 메서드를 오버라이딩하지 않고
//		// 사용자의 요청 방식에 맞는 처리를 할 수 있게 해주는 다른 메서드를 오버라이딩 함
//		System.out.println("Second 서블릿의 service() 메서드 호출!");
//	}
	
}







