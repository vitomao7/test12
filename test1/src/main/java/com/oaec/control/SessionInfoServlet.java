package com.oaec.control;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oaec.mt.service.impl.MovieServiceImpl;
import com.oaec.mt.service.impl.SessionServiceImpl;
import com.oaec.pojo.PageModel;

public class SessionInfoServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nowPage = req.getParameter("nowPage");
		String pageCount = req.getParameter("pageCount");
		nowPage = nowPage ==null?"1":nowPage;
		pageCount = pageCount==null?"10":pageCount;
		
		PageModel<Map<String, String>> pageModel = new SessionServiceImpl().querySessionPage(nowPage, pageCount);
		System.out.println(pageModel);
		
		req.setAttribute("model", pageModel);
		req.getRequestDispatcher(resp.encodeURL("sessioninfo.jsp")).forward(req, resp);
	}
}
