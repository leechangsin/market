package chapter7;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

// 서블릿은 일반적인 클래스를 HttpServlet 클래스의 자식 클래스로 만들면 서블릿이됨
// 그 후 web.xml에 등록을 해줬음
// 그 후 등록한 서블릿의 URL 매핑을 해줘서 클라이언트가 접근할 수 있도록 했음

// 필터는 일반적인 클래스를 Filter 인터페이스를 구현하도록 만들면 필터가 됨
// 그 후 web.xml에 필터 등록을 해야함
// 그 후 필터가 동작하도록 URL 매핑을 해줘야함
public class Filter1 implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// 필터는 서버가 시작될 때 생성됨, 서버가 종료될 때 사라짐
		System.out.println("<< Filter1 init 메서드 호출 >>");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("<< Filter1 doFilter 메서드 호출 >>");
		
		System.out.println("<< doFilter() 호출 전 >>");
		
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<head>");
		out.print("		<title>servlet1</title>");
		out.print("</head>");
		out.print("<body>");
		
		chain.doFilter(request, response);
		
		System.out.println("<< doFilter() 호출 후 >>");
		
		out.print("</body>");
		out.print("</html>");
		
		out.close();
	}
}








