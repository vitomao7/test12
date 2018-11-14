package com.oaec.mt.dao;

import java.util.List;
import java.util.Map;

public interface ISessionDao {
	/**
	 * 分页查询场次信息
	 * @param nowPage
	 * @param pageCount
	 * @return
	 */
	List<Map<String, String>> querySessionByPage(String nowPage,String pageCount);
	
	/**
	 * 查询总有多少条记录
	 * @return
	 */
	int queryAllSessionsCount();
}
