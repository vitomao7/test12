package com.oaec.mt.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import com.oaec.mt.dao.IBaseDao;
import com.oaec.mt.dao.impl.BaseDaoImpl;
import com.oaec.mt.service.IRightService;
import com.oaec.pojo.FirstRight;
import com.oaec.pojo.SecRight;

public class RightServiceImpl implements IRightService {
	private IBaseDao baseDao = new BaseDaoImpl();
	@Override
	public List<FirstRight> queryAllRights() {
		List<FirstRight> list = new ArrayList<>();
		String sql = "select s.right_id s_id,s.right_name s_name,s.right_url,"
				+ "f.right_id p_id,f.right_name p_name "
				+ "from rights s, rights f "
				+ "where s.p_id = f.right_id";
		
		List<Map<String, String>> r = baseDao.queryForList(sql);
		//System.out.println(r);
		for (Map<String, String> map : r) {
			
			boolean b = false;
			SecRight sec = new SecRight(map.get("S_NAME"), map.get("S_ID"), map.get("RIGHT_URL"));
			
			for(int i=0;i<list.size();i++){
				if(list.get(i).getRight_id().equals(map.get("P_ID"))){
					list.get(i).getSecRights().add(sec);
					b = true;
				}
			}
			
			if(!b){
				FirstRight f = new FirstRight();
				f.getSecRights().add(sec);
				f.setRight_id(map.get("P_ID"));
				f.setRight_name(map.get("P_NAME"));
				list.add(f);
			}
			
			
		}
		System.out.println(list);
		return list;
	}

	public static void main(String[] args) {
		new RightServiceImpl().queryAllRights();
	}
	
	
	
}
