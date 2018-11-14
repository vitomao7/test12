package com.oaec.mt.service.impl;

import java.util.List;
import java.util.Map;

import com.oaec.mt.dao.IBaseDao;
import com.oaec.mt.dao.impl.BaseDaoImpl;
import com.oaec.mt.service.ICinemaService;

public class CinemaServiceImpl implements ICinemaService{
	private IBaseDao baseDao = new BaseDaoImpl();
	@Override
	public List<Map<String, String>> queryAllCinemas() {
		String sql = "select * from cinemas";
		return baseDao.queryForList(sql);
	}

}
