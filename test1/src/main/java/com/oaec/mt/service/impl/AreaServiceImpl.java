package com.oaec.mt.service.impl;

import java.util.List;
import java.util.Map;

import com.oaec.mt.dao.IBaseDao;
import com.oaec.mt.dao.impl.BaseDaoImpl;
import com.oaec.mt.service.IAreaService;

public class AreaServiceImpl implements IAreaService {
	private IBaseDao baseDao = new BaseDaoImpl();
	@Override
	public List<Map<String, String>> queryAllAreas() {
		String sql = "select * from areas ";
		return baseDao.queryForList(sql);
	}

}
