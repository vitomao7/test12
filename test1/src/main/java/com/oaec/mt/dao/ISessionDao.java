package com.oaec.mt.dao;

import java.util.List;
import java.util.Map;

public interface ISessionDao {
	/**
	 * ��ҳ��ѯ������Ϣ
	 * @param nowPage
	 * @param pageCount
	 * @return
	 */
	List<Map<String, String>> querySessionByPage(String nowPage,String pageCount);
	
	/**
	 * ��ѯ���ж�������¼
	 * @return
	 */
	int queryAllSessionsCount();
}
