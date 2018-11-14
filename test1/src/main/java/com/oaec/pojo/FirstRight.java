package com.oaec.pojo;

import java.util.ArrayList;
import java.util.List;

public class FirstRight {
	private String right_id;
	private String right_name;
	private List<SecRight> secRights = new ArrayList<>();
	public String getRight_id() {
		return right_id;
	}
	public void setRight_id(String right_id) {
		this.right_id = right_id;
	}
	public String getRight_name() {
		return right_name;
	}
	public void setRight_name(String right_name) {
		this.right_name = right_name;
	}
	public List<SecRight> getSecRights() {
		return secRights;
	}

	@Override
	public String toString() {
		return "FirstRight [right_id=" + right_id + ", right_name=" + right_name + ", secRights=" + secRights + "]";
	}
	
	
}
