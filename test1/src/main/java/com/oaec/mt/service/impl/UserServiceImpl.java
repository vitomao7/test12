package com.oaec.mt.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.oaec.mt.dao.IBaseDao;
import com.oaec.mt.dao.IUserDao;
import com.oaec.mt.dao.impl.BaseDaoImpl;
import com.oaec.mt.dao.impl.UserDaoImpl;
import com.oaec.mt.service.IUserService;
import com.oaec.pojo.PageModel;
import com.oaec.pojo.User;

public class UserServiceImpl implements IUserService{
	private IBaseDao baseDao = new BaseDaoImpl();
	private IUserDao userDao = new UserDaoImpl();
	@Override
	public PageModel<User> queryUserPage(String nowPage, String pageCount) {
		PageModel<User> users = new PageModel<>();
		List<Map<String, String>> list = userDao.queryUserByPage(nowPage, pageCount);
		List<User> u = new ArrayList<>();
		//mapÈÝÆ÷»»³Éuser¶ÔÏóÈÝÆ÷
		for (Map<String, String> map : list) {
			User user = new User();
			user.setUserId(map.get("USER_ID"));
			user.setUserName(map.get("USER_NAME"));
			user.setUserPwd(map.get("USER_PWD"));
			user.setUserType(map.get("USER_TYPE"));
			user.setUserExtra(map.get("USER_EXTRA"));
			u.add(user);
		}
		int totalCounts = userDao.queryAllUsersCount();

		
		int totalPages = totalCounts%Integer.parseInt(pageCount)==0?totalCounts/Integer.parseInt(pageCount):
			totalCounts/Integer.parseInt(pageCount)+1;
		users.setModels(u);
		users.setTotalCounts(totalCounts+"");
		users.setNowPage(nowPage);
		users.setPageCount(pageCount);
		users.setTotalPages(totalPages+"");
			
		return users;
	}
	@Override
	public int insertUser(String name, String type, String pwd, String extra) {
		String sql = "insert into users(user_id,user_name,user_type,user_pwd,user_extra) "
				+ "values(seq_users.nextval,'"+name+"','"+type+"','"+pwd+"','"+extra+"')";
		return baseDao.executeUpdate(sql);
	}
	@Override
	public int deleteUsers(String ids) {
		String sql = "delete from users where user_id in("+ids+")";
		return baseDao.executeUpdate(sql);
	}
	@Override
	public List<Map<String, String>> login(String name, String pwd) {
		String sql = "select * from users "
				+ "where user_name='"+name+"' and  user_pwd='"+pwd+"' ";
		return baseDao.queryForList(sql);
	}

}
