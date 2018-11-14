<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	//
	String id = request.getParameter("id");

	//调用service层方法
	//Movie m =new MoiveServiceImpl().queryMovieById(id);
	
	//request.setAttribute("m", m);
	//如果需要动态获取影厅信息
	//List<Hall> halls =new HallServieImpl().queryHallByMoiveId(id);
	//request.setAttribute("hall", halls);
	
	
	request.getRequestDispatcher("cinemaSel.jsp").forward(request, response);

%>