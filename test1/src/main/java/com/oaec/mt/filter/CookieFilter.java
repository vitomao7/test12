package com.oaec.mt.filter;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.oaec.mt.service.impl.UserServiceImpl;

public class CookieFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
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
		String name = "";
		String pwd = "";
		
		
		if(session.getAttribute("users") == null){
			//未登录状态，先遍历所有的cookie,检查是否有存储用户名和密码的cookie
			Cookie[] cookies = request.getCookies();//获得所有的cookie
			if(cookies!=null){
				for (Cookie cookie : cookies) {
					if("name".equals(cookie.getName())){
						name = cookie.getValue();
					}else if("pwd".equals(cookie.getName())){
						pwd = cookie.getValue();
					}
				}
			}
			//如果用户名和密码在cookie取出了值
			if(!"".equals(name)&&!"".equals(pwd)){
				List<Map<String, String>> users = new UserServiceImpl().login(name, pwd);
				session.setAttribute("users", users);
				chain.doFilter(request, response);
			}else if(uri.contains("/LoginServlet.do")){
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
		// TODO Auto-generated method stub
		
	}

}
