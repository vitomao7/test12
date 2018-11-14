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

		//���session,reqԭ������HttpServletRequest���͵Ķ����������������ǿת
		//�������κδ���
		HttpServletRequest request  = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		
		HttpSession session = request.getSession();
		String uri = request.getRequestURI();
		String name = "";
		String pwd = "";
		
		
		if(session.getAttribute("users") == null){
			//δ��¼״̬���ȱ������е�cookie,����Ƿ��д洢�û����������cookie
			Cookie[] cookies = request.getCookies();//������е�cookie
			if(cookies!=null){
				for (Cookie cookie : cookies) {
					if("name".equals(cookie.getName())){
						name = cookie.getValue();
					}else if("pwd".equals(cookie.getName())){
						pwd = cookie.getValue();
					}
				}
			}
			//����û�����������cookieȡ����ֵ
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
			//chain ����������������滹�й�����������ͨ�������������ӵ�����Ĺ�����
			//���û�У���ô�������ӵ������servlet
			chain.doFilter(request, response);
		}
	
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
