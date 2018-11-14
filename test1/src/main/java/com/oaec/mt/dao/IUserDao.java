package com.oaec.mt.dao;

import java.util.List;
import java.util.Map;

public interface IUserDao {
	/**
	 * 分页查询用户信息
	 * @param nowPage 当前第几页
	 * @param pageCount 每页有多少条数据
	 * @return
	 */
	List<Map<String, String>> queryUserByPage(String nowPage,String pageCount);
	
	/**
	 * 查询总有多少条记录
	 * @return
	 */
	int queryAllUsersCount();
}
