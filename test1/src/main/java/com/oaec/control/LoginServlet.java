package com.oaec.control;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oaec.mt.service.impl.UserServiceImpl;

public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("userName");
		String pwd = req.getParameter("userPwd");
		
		//service�㷽��
		List<Map<String, String>> users = new UserServiceImpl().login(name, pwd);
		System.out.println(name+","+pwd);
		
		HttpSession session = req.getSession(true);
		//req.getSession(true)���sessionʱ�����ж�session�ǲ��Ǵ��ڣ���������򷵻ظ�session
		//�������������㴴��һ���µ�session����getSession();
		//req.getSession(false);�����session�����򷵻ظ�session,����������򷵻�null
		if(users.size()>0){
			session.setAttribute("users", users);
			session.setMaxInactiveInterval(10000);//����session������ʱ��,��λ��
			
	
			req.getRequestDispatcher("AdminIndexServlet.do").forward(req, resp);
		}else{
			resp.sendRedirect("login.jsp");
		}
		
		
		
	}
}
