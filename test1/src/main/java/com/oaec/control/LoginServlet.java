package com.oaec.control;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oaec.mt.service.impl.UserServiceImpl;

public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("userName");
		String pwd = req.getParameter("userPwd");
		
		//service层方法
		List<Map<String, String>> users = new UserServiceImpl().login(name, pwd);
		System.out.println(name+","+pwd);
		
		HttpSession session = req.getSession(true);
		//req.getSession(true)获得session时候，先判断session是不是存在，如果存在则返回该session
		//如果不存在则给你创建一个新的session，与getSession();
		//req.getSession(false);如果该session存在则返回该session,如果不存在则返回null
		if(users.size()>0){
			session.setAttribute("users", users);
			session.setMaxInactiveInterval(10000);//设置session的生存时间,单位秒
			
	
			req.getRequestDispatcher("AdminIndexServlet.do").forward(req, resp);
		}else{
			resp.sendRedirect("login.jsp");
		}
		
		
		
	}
}
