package com.revature.ndfinancial.retail.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "special")
public class Special {
	@Id
	@Column(name = "id")
	private String id;
	@Column(name = "description")
	private String desc;
	@Column(name = "active")
	private Boolean active;
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
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "Special [id=" + id + ", desc=" + desc + ", active=" + active + "]";
	}
	
	
}
