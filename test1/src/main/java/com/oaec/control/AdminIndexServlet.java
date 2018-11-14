package com.oaec.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oaec.mt.service.impl.RightServiceImpl;
import com.oaec.pojo.FirstRight;

public class AdminIndexServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//实现的代码
		List<FirstRight> rights = new RightServiceImpl().queryAllRights();
		
		req.setAttribute("rights", rights);
		
		req.getRequestDispatcher("adminIndex.jsp").forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}

	
}
