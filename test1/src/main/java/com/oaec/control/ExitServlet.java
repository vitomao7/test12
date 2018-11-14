package com.oaec.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ExitServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
//		session.invalidate();//设置session失效方法，
		session.setMaxInactiveInterval(5);//d
//	    System.out.println("12");                                                                                                                 	
//		req.getRequestDispatcher("AdminIndexServlet.do").forward(req, resp);
		resp.sendRedirect("UserInfoServlet.do");
	}
}
