package com.oaec.mt.service;

import java.util.List;
import java.util.Map;

import com.oaec.pojo.PageModel;
import com.oaec.pojo.User;

public interface IMovieService {
	/**
	 * ��ѯ���еĵ�Ӱ��Ϣ
	 */
	List<Map<String, String>> queryAllMovies();
	
	/**
	 * ��ѯǰ������Ӱ��Ϣ����ҳ��ѯ��
	 * @return
	 */
	List<Map<String, String>> queryEightMovies();
	
	/**
	 * ����Ʊ�������ѯǰʮ����Ӱ��Ϣ
	 * @return
	 */
	List<Map<String, String>> queryTenMoviesDescBox();
	
	/**
	 * ͨ��id��ѯ��Ӱ������Ϣ
	 * @param id
	 * @return
	 */
	List<Map<String, String>> queryMovieById(String id);
	/**
	 * ��ҳ��ѯ��Ӱ��Ϣ
	 * @param nowPage
	 * @param pageCount
	 * @return
	 */
	PageModel<Map<String,String>> queryMoviePage(String nowPage,String pageCount);
	
	
	
}
