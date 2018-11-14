package com.oaec.mt.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.oaec.mt.dao.IBaseDao;
import com.oaec.mt.dao.ISessionDao;
import com.oaec.mt.dao.impl.BaseDaoImpl;
import com.oaec.mt.dao.impl.SessionDaoImpl;
import com.oaec.mt.service.ISessionService;
import com.oaec.pojo.PageModel;

public class SessionServiceImpl implements ISessionService {
	private IBaseDao baseDao = new BaseDaoImpl();
	private ISessionDao sessionDao = new SessionDaoImpl();
	@Override
	public List<Map<String, String>> querySessionSel(String movieId, String hallId, String areaId, String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String sql = "select c.cinema_name,c.cinema_address,min(s.session_price) price from SESSIONS s,cinemas c "
				+ "where s.cinema_id = c.cinema_id and s.movie_id="+movieId;
		if(areaId!=null&&!"-1".equals(areaId)){
			sql = sql +" and c.area_id="+areaId;
		}
		if(hallId!=null&&!"-1".equals(hallId)){
			sql = sql+" and s.hall_id="+hallId;
		}
		if(date!=null){
			try {
				Date parse = sdf.parse(date);
				String format = sdf.format(parse);
				sql = sql + " and s.session_date='"+format+"'";
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else{
			
			String format = sdf.format(new Date());
			sql = sql + " and s.session_date='"+format+"'";
			
		}
		
		sql =sql +" group by c.cinema_name,c.cinema_address";
		System.out.println(sql);
		return baseDao.queryForList(sql);
	}
	@Override
	public PageModel<Map<String, String>> querySessionPage(String nowPage, String pageCount) {
		PageModel<Map<String, String>> ses = new PageModel<>();
		List<Map<String, String>> model = sessionDao.querySessionByPage(nowPage, pageCount);
		ses.setModels(model);
		ses.setNowPage(nowPage);
		ses.setPageCount(pageCount);
		
		int totalCount = sessionDao.queryAllSessionsCount();
		int totalPage = totalCount%Integer.parseInt(pageCount)==0?
				totalCount/Integer.parseInt(pageCount):totalCount/Integer.parseInt(pageCount)+1;
		ses.setTotalCounts(totalCount+"");
		ses.setTotalPages(totalPage+"");
		return ses;
	}

}
