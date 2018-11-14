package com.oaec.mt.service.impl;

import java.util.List;
import java.util.Map;


import com.oaec.mt.dao.IBaseDao;
import com.oaec.mt.dao.IMovieDao;
import com.oaec.mt.dao.impl.BaseDaoImpl;
import com.oaec.mt.dao.impl.MovieDaoImpl;
import com.oaec.mt.service.IMovieService;
import com.oaec.pojo.PageModel;

public class MovieServiceImpl implements IMovieService{
	private IBaseDao baseDao = new BaseDaoImpl();
	
	private IMovieDao movieDao = new MovieDaoImpl();
	@Override
	public List<Map<String, String>> queryEightMovies() {
		String sql = "select * from movies where rownum<9";
		return baseDao.queryForList(sql);
	}

	@Override
	public List<Map<String, String>> queryTenMoviesDescBox() {
		String sql = "select * from movies where rownum<11 order by movie_box desc ";
		System.out.println(sql);
		return baseDao.queryForList(sql);
	}
	
	public static void main(String[] args) {
		System.out.println(new MovieServiceImpl().queryEightMovies());
	}

	@Override
	public List<Map<String, String>> queryMovieById(String id) {
		String sql ="select * from movies m,types t,mov_type mt "
				+ "where m.movie_id = mt.movie_id and mt.type_id = t.type_id "
				+ "and m.movie_id = "+id;
		System.out.println(sql);
		return baseDao.queryForList(sql);
	}

	@Override
	public PageModel<Map<String, String>> queryMoviePage(String nowPage, String pageCount) {
		PageModel<Map<String, String>> mov = new PageModel<>();
		
		List<Map<String, String>> model = movieDao.queryMovieByPage(nowPage, pageCount);
		mov.setModels(model);
		mov.setNowPage(nowPage);
		mov.setPageCount(pageCount);
		
		int totalCount = movieDao.queryAllMoviesCount();
		int totalPage = totalCount%Integer.parseInt(pageCount)==0?
				totalCount/Integer.parseInt(pageCount):totalCount/Integer.parseInt(pageCount)+1;
		mov.setTotalCounts(totalCount+"");
		mov.setTotalPages(totalPage+"");
		
		return mov;
	}

	@Override
	public List<Map<String, String>> queryAllMovies() {
		String sql = "select * from movies";
		return baseDao.queryForList(sql);
	}
	
}
