package com.oaec.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oaec.mt.service.impl.UserServiceImpl;

public class InsertUserServlet extends HttpServlet{

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String name = req.getParameter("name");
			String pwd = req.getParameter("pwd");
			String type = req.getParameter("type");
			String extra = req.getParameter("extra");
			
			//
			int i = new UserServiceImpl().insertUser(name, type, pwd, extra);
			//在使用out输出中文数据的时候，一定设置一下字符集
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			
			if(i>0){
				out.print("插入成功");
			}else{
				out.println("插入失败");
			}
			
			
		}
}
