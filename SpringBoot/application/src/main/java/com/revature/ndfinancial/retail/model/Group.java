package com.revature.ndfinancial.retail.model;

public class Group {
	private String id;
	private String desc;
	private String groupId;
	private String range;
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
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getRange() {
		return range;
	}
	public void setRange(String range) {
		this.range = range;
	}
	@Override
	public String toString() {
		return "Group [id=" + id + ", desc=" + desc + ", groupId=" + groupId + ", range=" + range + "]";
	}
	
}
