package com.oaec.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oaec.mt.service.impl.HallServiceImpl;

import net.sf.json.JSONArray;

public class QueryHallsServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String  cinemaId = req.getParameter("cid");
		List<Map<String, String>> halls = new HallServiceImpl().queryHallsByCinemaId(cinemaId);
		
		JSONArray jbhalls = JSONArray.fromObject(halls);
		resp.setContentType("text/application;charset=utf-8");
		PrintWriter writer = resp.getWriter();
		System.out.println(jbhalls.toString());
		writer.print(jbhalls);
		
	}
}
