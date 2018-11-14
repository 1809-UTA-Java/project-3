package com.revature.ndfinancial.retail.model;

public class Special {
	private String id;
	private String desc;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	@Override
	public String toString() {
		return "Special [id=" + id + ", desc=" + desc + "]";
	}
	
}
