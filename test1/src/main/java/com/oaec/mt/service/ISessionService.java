package com.oaec.mt.service;

import java.util.List;
import java.util.Map;

import com.oaec.pojo.PageModel;
import com.oaec.pojo.User;

public interface ISessionService {
	
	/**
	 * 电影详情页面，根据指定条件查询所有影院信息
	 * @param movieId
	 * @param hallId
	 * @param areaId
	 * @param date
	 * @return
	 */
	List<Map<String, String>> querySessionSel(String movieId,String hallId,String areaId,String date);
	/**
	 * 分页查询场次信息
	 * @param nowPage
	 * @param pageCount
	 * @return
	 */
	PageModel<Map<String,String>> querySessionPage(String nowPage,String pageCount);
}
