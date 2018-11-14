package com.oaec.mt.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		System.out.println("loginFiler---destory");
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		//获得session,req原本就是HttpServletRequest类型的对象，所以在这里进行强转
		//不会有任何错误
		HttpServletRequest request  = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		
		HttpSession session = request.getSession();
		String uri = request.getRequestURI();
	
		if(session.getAttribute("users") == null){
			if(uri.contains("/LoginServlet.do")){
				chain.doFilter(request, response);
			}else{
				request.getRequestDispatcher("login.jsp").forward(request, response);
//				response.sendRedirect("login.jsp");
			}
				
			
		}else{
			//chain 过滤器链。如果后面还有过滤器，就是通过过滤器链连接到后面的过滤器
			//如果没有，那么就是连接到后面的servlet
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("loginFiler---init");
		
	}

}
