package com.oaec.mt.service;

import java.util.List;
import java.util.Map;

import com.oaec.pojo.PageModel;
import com.oaec.pojo.User;

public interface IUserService {
	/**
	 * 分页查询用户信息
	 * @param nowPage
	 * @param pageCount
	 * @return
	 */
	PageModel<User> queryUserPage(String nowPage,String pageCount);
	
	/**
	 * 插入一个用户的方法
	 * @param name
	 * @param type
	 * @param pwd
	 * @param extra
	 * @return
	 */
	int insertUser(String name,String type,String pwd,String extra);
	/**
	 * 批量删除用户信息
	 * @param ids
	 * @return
	 */
	int deleteUsers(String ids);
	
	/**
	 * 登录
	 * @param name
	 * @param pwd
	 * @return
	 */
	List<Map<String, String>> login(String name,String pwd);
	
}
