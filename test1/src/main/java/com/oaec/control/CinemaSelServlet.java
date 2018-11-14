package com.oaec.control;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oaec.mt.service.impl.AreaServiceImpl;
import com.oaec.mt.service.impl.HallServiceImpl;
import com.oaec.mt.service.impl.MovieServiceImpl;
import com.oaec.mt.service.impl.SessionServiceImpl;

public class CinemaSelServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//��ѯָ����ĳ����Ӱ��������Ϣ
		String movieId = req.getParameter("id");
		//������ڣ�Ӱ��id�͵�Ӱid,������id
		String hallId = req.getParameter("hallId");
		String areaId = req.getParameter("areaId");
		String date = req.getParameter("date");
		
		
		
		
		if(hallId==null){
			req.setAttribute("hallId", "-1");
		}else{
			req.setAttribute("hallId", hallId);
		}
		if(date==null){
			req.setAttribute("date", "-1");
		}else{
			req.setAttribute("date", date);
		}	
		if(areaId == null){
			req.setAttribute("areaId", "-1");
		}else{
			req.setAttribute("areaId", areaId);
		}
		System.out.println(hallId+","+areaId+","+date+","+movieId);
		List<Map<String, String>> movie = new MovieServiceImpl().queryMovieById(movieId);
		req.setAttribute("movie", movie);
		List<Map<String, String>> sessions = new SessionServiceImpl().querySessionSel(movieId, hallId, areaId, date);
		System.out.println(sessions);
		req.setAttribute("sessions", sessions);
		//��ҪӰ�������ڣ���������Ʒ��
		List<Map<String, String>> areas = new AreaServiceImpl().queryAllAreas();
		List<Map<String, String>> halls = new HallServiceImpl().queryAllHalls();
		req.setAttribute("areas", areas);
		req.setAttribute("halls", halls);
		
		//��ת��view��
		req.getRequestDispatcher("cinemaSel.jsp").forward(req, resp);
		
		
		
	}
}
