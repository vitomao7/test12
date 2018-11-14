package com.oaec.mt.service;

import java.util.List;
import java.util.Map;

import com.oaec.pojo.PageModel;
import com.oaec.pojo.User;

public interface ISessionService {
	
	/**
	 * ��Ӱ����ҳ�棬����ָ��������ѯ����ӰԺ��Ϣ
	 * @param movieId
	 * @param hallId
	 * @param areaId
	 * @param date
	 * @return
	 */
	List<Map<String, String>> querySessionSel(String movieId,String hallId,String areaId,String date);
	/**
	 * ��ҳ��ѯ������Ϣ
	 * @param nowPage
	 * @param pageCount
	 * @return
	 */
	PageModel<Map<String,String>> querySessionPage(String nowPage,String pageCount);
}
