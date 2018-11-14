package com.oaec.mt.dao;

import java.util.List;
import java.util.Map;

public interface IUserDao {
	/**
	 * ��ҳ��ѯ�û���Ϣ
	 * @param nowPage ��ǰ�ڼ�ҳ
	 * @param pageCount ÿҳ�ж���������
	 * @return
	 */
	List<Map<String, String>> queryUserByPage(String nowPage,String pageCount);
	
	/**
	 * ��ѯ���ж�������¼
	 * @return
	 */
	int queryAllUsersCount();
}
