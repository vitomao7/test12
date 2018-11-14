package com.oaec.mt.dao.impl;

import java.util.List;
import java.util.Map;

import com.oaec.mt.dao.IBaseDao;
import com.oaec.mt.dao.ISessionDao;

public class SessionDaoImpl implements ISessionDao {
	private IBaseDao baseDao = new BaseDaoImpl();
	@Override
	public List<Map<String, String>> querySessionByPage(String nowPage, String pageCount) {
		String sql = "select * from (select se.*,rownum rn from "
				+ "(select s.session_id,c.cinema_name,h.hall_name,m.movie_name,"
				+ "s.session_start,s.session_end,s.session_lan,s.session_price,"
				+ "s.session_date from sessions s,cinemas c,halls h,movies m "
				+ "where s.cinema_id = c.cinema_id and s.hall_id = h.hall_id "
				+ "and s.movie_id=m.movie_id) se "
				+ "where rownum < "+(Integer.parseInt(nowPage)*Integer.parseInt(pageCount)+1)+") "
				+ "where rn>"+(Integer.parseInt(nowPage)-1)*Integer.parseInt(pageCount);
		return baseDao.queryForList(sql);
	}

	@Override
	public int queryAllSessionsCount() {
		String sql = "select count(session_id) c from sessions";
		List<Map<String, String>> list = baseDao.queryForList(sql);
		int i = Integer.parseInt(list.get(0).get("C"));
		return i;
	}

}
