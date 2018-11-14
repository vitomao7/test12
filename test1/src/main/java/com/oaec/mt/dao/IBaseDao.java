package com.oaec.mt.dao;

import java.util.List;
import java.util.Map;

public interface IBaseDao {
	/**
	 * ͨ�õ�dml����
	 * @return ��Ӱ�������
	 */
	int executeUpdate(String sql);
	
	/**
	 * ͨ�ò�ѯ����
	 * @param sql 
	 * @return һ��map��һ�����ݣ�һ��list���Ƕ�������
	 */
	List<Map<String, String>> queryForList(String sql);
	
	/**
	 * ��������dml���
	 * @param sql һ��Ҫ�γ������sql���
	 * @return
	 */
	int executeUpdateTran(List<String> sql);
	
	
	
	
}
