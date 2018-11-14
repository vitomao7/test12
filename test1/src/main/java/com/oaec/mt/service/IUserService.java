package com.oaec.mt.service;

import java.util.List;
import java.util.Map;

import com.oaec.pojo.PageModel;
import com.oaec.pojo.User;

public interface IUserService {
	/**
	 * ��ҳ��ѯ�û���Ϣ
	 * @param nowPage
	 * @param pageCount
	 * @return
	 */
	PageModel<User> queryUserPage(String nowPage,String pageCount);
	
	/**
	 * ����һ���û��ķ���
	 * @param name
	 * @param type
	 * @param pwd
	 * @param extra
	 * @return
	 */
	int insertUser(String name,String type,String pwd,String extra);
	/**
	 * ����ɾ���û���Ϣ
	 * @param ids
	 * @return
	 */
	int deleteUsers(String ids);
	
	/**
	 * ��¼
	 * @param name
	 * @param pwd
	 * @return
	 */
	List<Map<String, String>> login(String name,String pwd);
	
}
