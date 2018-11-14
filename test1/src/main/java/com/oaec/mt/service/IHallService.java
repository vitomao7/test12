package com.oaec.mt.service;

import java.util.List;
import java.util.Map;

public interface IHallService {
	/**
	 * 查询所有的影厅数据
	 * @return
	 */
	List<Map<String, String>> queryAllHalls();
	/**
	 * 根据影院查询所有的影厅信息
	 * @param cinemaId
	 * @return
	 */
	List<Map<String, String>> queryHallsByCinemaId(String cinemaId);
}
