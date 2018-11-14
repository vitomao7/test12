package com.oaec.control;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oaec.mt.service.impl.CinemaServiceImpl;
import com.oaec.mt.service.impl.MovieServiceImpl;

public class SelectMovieCinemaServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//查询所有的影院和电影信息
		List<Map<String, String>> movies = new MovieServiceImpl().queryAllMovies();
		List<Map<String, String>> cinemas = new CinemaServiceImpl().queryAllCinemas();
		
		req.setAttribute("movies", movies);
		req.setAttribute("cinemas", cinemas);
		
		req.getRequestDispatcher("addsession.jsp").forward(req, resp);
	}
}
