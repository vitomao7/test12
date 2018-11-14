package com.oaec.mt.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SesListener implements HttpSessionListener,HttpSessionAttributeListener{
	/**
	 * ͨ����session�ļ�����ʵ����վ����������ͳ��
	 * ���������������͵�ͬ��ͬʱ���ڵ�session������
	 * ͬʱ���ڵ�session�������������ͼ�һ��ɾ����һ
	 * ���������������ŵ������ֻ�ܽ�ͳ�������������ŵ���������
	 */
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		//��������session������
		System.out.println("session��������");
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
		//��������session����
		System.out.println("session��������");
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
		//������session��������ݵ�
		System.out.println("�������");
		
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		//������session��ɾ�����ݵ�
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		//������session���滻���ݵ�
		
	}

}
