package com.oaec.pojo;

public class SecRight {
	private String right_name;
	private String right_id;
	private String right_url;
	public String getRight_name() {
		return right_name;
	}
	public void setRight_name(String right_name) {
		this.right_name = right_name;
	}
	public String getRight_id() {
		return right_id;
	}
	public void setRight_id(String right_id) {
		this.right_id = right_id;
	}
	public String getRight_url() {
		return right_url;
	}
	public void setRight_url(String right_url) {
		this.right_url = right_url;
	}
	public SecRight(String right_name, String right_id, String right_url) {
		super();
		this.right_name = right_name;
		this.right_id = right_id;
		this.right_url = right_url;
	}
	public SecRight() {
		super();
	}
	@Override
	public String toString() {
		return "SecRight [right_name=" + right_name + ", right_id=" + right_id + ", right_url=" + right_url + "]";
	}

	
	
}
