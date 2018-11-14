package com.oaec.control;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oaec.mt.service.impl.UserServiceImpl;

public class CookieServletLogin extends HttpServlet{
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("userName");
		String pwd = req.getParameter("userPwd");
		
		HttpSession session = req.getSession();
		List<Map<String, String>> users = new UserServiceImpl().login(name, pwd);
		
		if(users.size()>0){
			session.setAttribute("users", users);
			//
			Cookie cookieName = new Cookie("name", name);
			Cookie cookiePwd = new Cookie("pwd", pwd);
			
			cookieName.setMaxAge(7*24*60*60);//单位秒 设置7天
			cookiePwd.setMaxAge(7*24*60*60);
			
			resp.addCookie(cookieName);
			resp.addCookie(cookiePwd);
			
			req.getRequestDispatcher("AdminIndexServlet.do").forward(req, resp);
		}else{
			resp.sendRedirect("login.jsp");
		}
		
	}
}
