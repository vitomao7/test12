package com.oaec.mt.service;

import java.util.List;
import java.util.Map;

public interface IAreaService {
	/**
	 * 查询所有的行政地区
	 * @return
	 */
	List<Map<String, String>> queryAllAreas();
}
