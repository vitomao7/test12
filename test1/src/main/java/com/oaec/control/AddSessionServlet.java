package com.oaec.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddSessionServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String movieId = req.getParameter("movieId");
		String cinemaId = req.getParameter("cinemaId");
		String hallId = req.getParameter("hallId");
		String price = req.getParameter("price");
		String lan = req.getParameter("lan");
		String date = req.getParameter("date");
		String start = req.getParameter("start");
		
		System.out.println(movieId+","+cinemaId+","+hallId+","+price+","+lan+","+date+","+start);
				
	}
}
