package com.oaec.mt.dao;

import java.util.List;
import java.util.Map;

public interface IMovieDao {
	/**
	 * 分页查询电影信息
	 * @param nowPage
	 * @param pageCount
	 * @return
	 */
	List<Map<String, String>> queryMovieByPage(String nowPage,String pageCount);
	
	/**
	 * 查询总有多少条记录
	 * @return
	 */
	int queryAllMoviesCount();
}
