package com.oaec.pojo;

import java.util.List;

public class PageModel<T> {
	
	private List<T> models;
	//ÿҳ��������
	private String pageCount;
	//��ѯ��ǰ�ĵڼ�ҳ
	private String nowPage;
	//�ܹ��ж���������
	private String totalCounts;
	//�ܹ��ֶ���ҳ
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
