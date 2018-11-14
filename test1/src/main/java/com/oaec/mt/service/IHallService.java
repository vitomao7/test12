package com.oaec.mt.service;

import java.util.List;
import java.util.Map;

public interface IHallService {
	/**
	 * ��ѯ���е�Ӱ������
	 * @return
	 */
	List<Map<String, String>> queryAllHalls();
	/**
	 * ����ӰԺ��ѯ���е�Ӱ����Ϣ
	 * @param cinemaId
	 * @return
	 */
	List<Map<String, String>> queryHallsByCinemaId(String cinemaId);
}
