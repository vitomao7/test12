package com.oaec.mt.service.impl;

import java.util.List;
import java.util.Map;

import com.oaec.mt.dao.IBaseDao;
import com.oaec.mt.dao.impl.BaseDaoImpl;
import com.oaec.mt.service.IHallService;

public class HallServiceImpl implements IHallService {
	private IBaseDao baseDao = new BaseDaoImpl();
	@Override
	public List<Map<String, String>> queryAllHalls() {
		String sql = "select * from halls";
		return baseDao.queryForList(sql);
	}
	@Override
	public List<Map<String, String>> queryHallsByCinemaId(String cinemaId) {
		String sql = "select * from halls where cinema_id="+cinemaId;
		return baseDao.queryForList(sql);
	}

}
