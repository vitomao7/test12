package com.oaec.control;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oaec.mt.service.impl.MovieServiceImpl;

public class IndexServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.分析用户的请求（访问主界面）
		
		//2.至少从数据库中查询四个数据
		List<Map<String, String>> movies = new MovieServiceImpl().queryEightMovies();
		List<Map<String, String>> MoviesDescBox = new MovieServiceImpl().queryTenMoviesDescBox();
		
		req.setAttribute("movies", movies);
		req.setAttribute("box", MoviesDescBox);
		
		//3.跳转到view页面
		req.getRequestDispatcher("index.jsp").forward(req, resp);
		
		
	}
	
}
