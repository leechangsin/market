package chapter7;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class Filter3
 */
// urlPatterns, value : 필터가 동작할 URL을 지정 / 반드시 필요한 속성
// servletNames : 필터가 동작할 서블릿의 이름
// filterName : 필터의 이름
// initParams : 필터가 가져야할 초기 파라미터
@WebFilter(servletNames={"servlet1", "servlet2"})
public class Filter3 implements Filter {

    /**
     * Default constructor. 
     */
    public Filter3() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		// 필터가 사라질 때 (서버가 종료될 때) 동작하는 메서드
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
