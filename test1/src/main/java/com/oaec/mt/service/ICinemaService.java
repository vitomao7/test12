package com.oaec.mt.service;

import java.util.List;
import java.util.Map;

public interface ICinemaService {
	/**
	 * 查询所有的影院信息
	 * @return
	 */
	List<Map<String, String>> queryAllCinemas();
} 
