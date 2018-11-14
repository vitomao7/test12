package com.oaec.mt.dao.impl;

import java.util.List;
import java.util.Map;

import com.oaec.mt.dao.IBaseDao;
import com.oaec.mt.dao.IMovieDao;

public class MovieDaoImpl implements IMovieDao {
	private IBaseDao baseDao = new BaseDaoImpl();
	@Override
	public List<Map<String, String>> queryMovieByPage(String nowPage, String pageCount) {
		String sql = "select * from(select m.*,rownum rn from (select * from MOVIES) m "
				+ "where rownum<"+(Integer.parseInt(nowPage)*Integer.parseInt(pageCount)+1)+") "
						+ "where rn>"+(Integer.parseInt(nowPage)-1)*Integer.parseInt(pageCount);
		return baseDao.queryForList(sql);
	}

	@Override
	public int queryAllMoviesCount() {
		String sql = "select count(*) c from movies";
		List<Map<String, String>> list = baseDao.queryForList(sql);
		int i = Integer.parseInt(list.get(0).get("C"));
		return i;
	}

}
