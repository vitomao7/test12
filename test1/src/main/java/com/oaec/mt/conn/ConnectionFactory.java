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
	
	//先从属性文件读取所用的四个值
	//写一个静态代码块来读取四个值
	static{
		//创建一个Properties对象
		Properties p = new Properties();
		//创建一个输入流与我们属性文件建立连接
		InputStream ism = ConnectionFactory.class.getResourceAsStream("jdbc.properties");
		
		//把这个流和Properties对象联系起来
		try {
			p.load(ism);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//一定要执行的代码，用来关闭资源
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
