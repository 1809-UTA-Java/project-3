package com.revature.ndfinancial.retail.model;

import java.util.List;

import org.springframework.data.annotation.Id;

public class Group {
	@Id
	private String id;
	private String name;
	private String desc;
	private List<String> userId;
	private Boolean active;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public List<String> getUserId() {
		return userId;
	}
	public void setUserId(List<String> userId) {
		this.userId = userId;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public Group(String name, String desc, List<String> userId, Boolean active) {
		super();
		this.name = name;
		this.desc = desc;
		this.userId = userId;
		this.active = active;
	}
	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + ", desc=" + desc + ", userId=" + userId + ", active=" + active
				+ "]";
	}
	
}