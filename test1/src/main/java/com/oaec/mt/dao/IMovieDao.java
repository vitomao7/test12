package com.oaec.mt.dao;

import java.util.List;
import java.util.Map;

public interface IMovieDao {
	/**
	 * ��ҳ��ѯ��Ӱ��Ϣ
	 * @param nowPage
	 * @param pageCount
	 * @return
	 */
	List<Map<String, String>> queryMovieByPage(String nowPage,String pageCount);
	
	/**
	 * ��ѯ���ж�������¼
	 * @return
	 */
	int queryAllMoviesCount();
}
