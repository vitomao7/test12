package com.oaec.mt.dao.impl;

import java.util.List;
import java.util.Map;

import com.oaec.mt.dao.IBaseDao;
import com.oaec.mt.dao.IUserDao;

public class UserDaoImpl implements IUserDao{
	
	private IBaseDao baseDao = new BaseDaoImpl();
	
	@Override
	public List<Map<String, String>> queryUserByPage(String nowPage, String pageCount) {
		String sql = "select * from (select u.*,rownum rn from (select * from users) u where rownum<"+(Integer.parseInt(nowPage)*Integer.parseInt(pageCount)+1)+") "
				+ "where rn>"+(Integer.parseInt(nowPage)-1)*Integer.parseInt(pageCount);
		return baseDao.queryForList(sql);
	}

	@Override
	public int queryAllUsersCount() {
		String sql = "select count(*) c from users";
		List<Map<String, String>> list = baseDao.queryForList(sql);
		int num = Integer.parseInt(list.get(0).get("C"));
		return num;
	}

}
