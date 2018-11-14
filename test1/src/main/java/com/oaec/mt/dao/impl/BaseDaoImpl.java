package com.oaec.mt.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.oaec.mt.conn.ConnectionFactory;
import com.oaec.mt.dao.IBaseDao;


public class BaseDaoImpl implements IBaseDao {
	
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	/**
	 * 关闭所有可用的连接
	 */
	private void closeAny() {
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	/**
	 * 通用dml语言
	 * @param sql
	 * @return
	 */
	public int executeUpdate(String sql){
		int i = 0;
		conn = ConnectionFactory.getConnection();
		try {
			stmt = conn.createStatement();
			i = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAny();
		}
		
		return i;
	}

	public List<Map<String,String>>  queryForList(String sql){
		
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		//创建一个存放所有列名的容器
		List<String> colSet = new ArrayList();
		conn = ConnectionFactory.getConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			//处理结果集
			
			//获得rs中所有列名???多少列
			ResultSetMetaData data = rs.getMetaData();
			//获得rs中总共有多少列
			int colNum = data.getColumnCount();
			
			for(int i=1;i<=colNum;i++){
				//将所有列名存放到容器中
				colSet.add(data.getColumnName(i));
			}
			
			while(rs.next()){
				//创建一个map来存放一条数据
				Map<String,String> map = new HashMap<String,String>();
				//map.put(key, rs.getString(key))//列名（key）应该如果获得
				for(int i=0;i<colSet.size();i++){
					map.put(colSet.get(i), rs.getString(colSet.get(i)));
				}
				list.add(map);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAny();
		}
		return list;
	
	}
	
	/**
	 * 通用的批量处理dml语句
	 * @param sql
	 * @return
	 */
	public int executeUpdateTran(List<String> sql){
		int i=0;
		conn = ConnectionFactory.getConnection();
		try {
			stmt = conn.createStatement();
			conn.setAutoCommit(false);//回滚到当前状态
			for (String s : sql) {
				i =i+stmt.executeUpdate(s);//第二次处理sql语句，出现异常SQLException
			}
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			closeAny();
		}
		return i;
	}

	
}
