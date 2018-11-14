package com.oaec.mt.service;

import java.util.List;
import java.util.Map;

import com.oaec.pojo.PageModel;
import com.oaec.pojo.User;

public interface IMovieService {
	/**
	 * 查询所有的电影信息
	 */
	List<Map<String, String>> queryAllMovies();
	
	/**
	 * 查询前八条电影信息（分页查询）
	 * @return
	 */
	List<Map<String, String>> queryEightMovies();
	
	/**
	 * 根据票房降序查询前十条电影信息
	 * @return
	 */
	List<Map<String, String>> queryTenMoviesDescBox();
	
	/**
	 * 通过id查询电影详情信息
	 * @param id
	 * @return
	 */
	List<Map<String, String>> queryMovieById(String id);
	/**
	 * 分页查询电影信息
	 * @param nowPage
	 * @param pageCount
	 * @return
	 */
	PageModel<Map<String,String>> queryMoviePage(String nowPage,String pageCount);
	
	
	
}
