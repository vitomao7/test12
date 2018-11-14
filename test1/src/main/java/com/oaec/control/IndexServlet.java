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
		//1.�����û������󣨷��������棩
		
		//2.���ٴ����ݿ��в�ѯ�ĸ�����
		List<Map<String, String>> movies = new MovieServiceImpl().queryEightMovies();
		List<Map<String, String>> MoviesDescBox = new MovieServiceImpl().queryTenMoviesDescBox();
		
		req.setAttribute("movies", movies);
		req.setAttribute("box", MoviesDescBox);
		
		//3.��ת��viewҳ��
		req.getRequestDispatcher("index.jsp").forward(req, resp);
		
		
	}
	
}
