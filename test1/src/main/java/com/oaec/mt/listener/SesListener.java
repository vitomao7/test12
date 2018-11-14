package com.oaec.mt.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SesListener implements HttpSessionListener,HttpSessionAttributeListener{
	/**
	 * 通过对session的监听来实现网站在线人数的统计
	 * 在线人数的数量就等同于同时存在的session的数据
	 * 同时存在的session的数量，创建就加一，删除减一
	 * 计算人数的数量放到哪里？？只能将统计人数的数量放到上下文中
	 */
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		//用来监听session创建的
		System.out.println("session被创建了");
		HttpSession session = arg0.getSession();
		ServletContext servletContext = session.getServletContext();
		
		
		Integer num = (Integer)servletContext.getAttribute("num");
		if(num == null){
			num = 1;
		}else{
			num ++;
		}
		servletContext.setAttribute("num", num);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		//用来监听session销毁
		System.out.println("session被销毁了");
		HttpSession session = arg0.getSession();
		ServletContext servletContext = session.getServletContext();
		Integer num = (Integer)servletContext.getAttribute("num");
		if(num!=null){
			num--;
		}
		
		servletContext.setAttribute("num", num);
		
		
	}

	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		//监听向session中添加数据的
		System.out.println("添加数据");
		
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		//监听从session中删除数据的
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		//监听从session的替换数据的
		
	}

}
