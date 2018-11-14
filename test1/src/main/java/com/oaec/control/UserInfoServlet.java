package com.oaec.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oaec.mt.service.impl.UserServiceImpl;
import com.oaec.pojo.PageModel;
import com.oaec.pojo.User;

public class UserInfoServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		String nowPage = req.getParameter("nowPage");
		String pageCount = req.getParameter("pageCount");
		nowPage = nowPage ==null?"1":nowPage;
		pageCount = pageCount==null?"10":pageCount;
		
		PageModel<User> pageModel = new UserServiceImpl().queryUserPage(nowPage, pageCount);
		
		
		req.setAttribute("model", pageModel);
		req.getRequestDispatcher(resp.encodeURL("userinfo.jsp")).forward(req, resp);
		
		
		
	}
}
