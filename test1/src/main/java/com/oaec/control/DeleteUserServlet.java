package com.oaec.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.oaec.mt.service.impl.UserServiceImpl;

public class DeleteUserServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ids = req.getParameter("ids");
		ids = ids.substring(0, ids.length()-1);
		if(ids.contains("id,")){
			ids = ids.replace("id,", "");
		}
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		
		//调用service层方法
		int i = new UserServiceImpl().deleteUsers(ids);
		
		if(i>0){
			out.println("删除成功");
		}else{
			out.println("删除失败");
		}
		
		
	}
}
