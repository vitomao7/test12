package com.oaec.mt.dao;

import java.util.List;
import java.util.Map;

public interface IBaseDao {
	/**
	 * 通用的dml方法
	 * @return 受影响的行数
	 */
	int executeUpdate(String sql);
	
	/**
	 * 通用查询方法
	 * @param sql 
	 * @return 一个map是一行数据，一个list就是多行数据
	 */
	List<Map<String, String>> queryForList(String sql);
	
	/**
	 * 批量处理dml语句
	 * @param sql 一组要形成事物的sql语句
	 * @return
	 */
	int executeUpdateTran(List<String> sql);
	
	
	
	
}
