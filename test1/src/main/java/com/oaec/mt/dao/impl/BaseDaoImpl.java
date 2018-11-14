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
	 * �ر����п��õ�����
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
	 * ͨ��dml����
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
		//����һ�������������������
		List<String> colSet = new ArrayList();
		conn = ConnectionFactory.getConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			//��������
			
			//���rs����������???������
			ResultSetMetaData data = rs.getMetaData();
			//���rs���ܹ��ж�����
			int colNum = data.getColumnCount();
			
			for(int i=1;i<=colNum;i++){
				//������������ŵ�������
				colSet.add(data.getColumnName(i));
			}
			
			while(rs.next()){
				//����һ��map�����һ������
				Map<String,String> map = new HashMap<String,String>();
				//map.put(key, rs.getString(key))//������key��Ӧ��������
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
	 * ͨ�õ���������dml���
	 * @param sql
	 * @return
	 */
	public int executeUpdateTran(List<String> sql){
		int i=0;
		conn = ConnectionFactory.getConnection();
		try {
			stmt = conn.createStatement();
			conn.setAutoCommit(false);//�ع�����ǰ״̬
			for (String s : sql) {
				i =i+stmt.executeUpdate(s);//�ڶ��δ���sql��䣬�����쳣SQLException
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
