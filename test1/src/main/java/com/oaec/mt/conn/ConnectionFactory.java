package com.oaec.mt.conn;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {
	private static String DRIVER;
	private static String URL;
	private static String USERNAME;
	private static String USERPWD;
	private static Connection conn = null;
	
	//�ȴ������ļ���ȡ���õ��ĸ�ֵ
	//дһ����̬���������ȡ�ĸ�ֵ
	static{
		//����һ��Properties����
		Properties p = new Properties();
		//����һ�������������������ļ���������
		InputStream ism = ConnectionFactory.class.getResourceAsStream("jdbc.properties");
		
		//���������Properties������ϵ����
		try {
			p.load(ism);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//һ��Ҫִ�еĴ��룬�����ر���Դ
			if(ism !=null){
				try {
					ism.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		DRIVER = p.getProperty("driver");
		URL = p.getProperty("url");
		USERNAME = p.getProperty("username");
		USERPWD = p.getProperty("userpwd");	
	}
	
	
	public static Connection getConnection(){
		
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USERNAME, USERPWD);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	
	
	public static void main(String[] args) {
		for(int i=0;i<=5;i++){
			System.out.println(ConnectionFactory.getConnection());
		}
		
	}
	
	
}
