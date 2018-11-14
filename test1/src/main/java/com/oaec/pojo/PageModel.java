package com.oaec.pojo;

import java.util.List;

public class PageModel<T> {
	
	private List<T> models;
	//每页多少条数
	private String pageCount;
	//查询当前的第几页
	private String nowPage;
	//总共有多少条数据
	private String totalCounts;
	//总共分多少页
	private String totalPages;
	public List<T> getModels() {
		return models;
	}
	public void setModels(List<T> models) {
		this.models = models;
	}
	public String getPageCount() {
		return pageCount;
	}
	public void setPageCount(String pageCount) {
		this.pageCount = pageCount;
	}
	public String getNowPage() {
		return nowPage;
	}
	public void setNowPage(String nowPage) {
		this.nowPage = nowPage;
	}
	public String getTotalCounts() {
		return totalCounts;
	}
	public void setTotalCounts(String totalCounts) {
		this.totalCounts = totalCounts;
	}
	public String getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(String totalPages) {
		this.totalPages = totalPages;
	}
	
	
	
	
	
	
	
	
	
}
