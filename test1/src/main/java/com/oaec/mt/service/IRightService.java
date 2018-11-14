package com.oaec.mt.service;

import java.util.List;

import com.oaec.pojo.FirstRight;

public interface IRightService {
	/**
	 * 查询所有权限信息
	 * @return
	 */
	List<FirstRight> queryAllRights();
}
