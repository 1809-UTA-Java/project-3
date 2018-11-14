package com.revature.ndfinancial.retail.model;

import java.util.Date;

public class Application {
	private String id;
	private String userId;
	private String offer;
	private Date started;
	private String status;
	private Date sentIn;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getOffer() {
		return offer;
	}
	public void setOffer(String offer) {
		this.offer = offer;
	}
	public Date getStarted() {
		return started;
	}
	public void setStarted(Date started) {
		this.started = started;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getSentIn() {
		return sentIn;
	}
	public void setSentIn(Date sentIn) {
		this.sentIn = sentIn;
	}
	@Override
	public String toString() {
		return "application [id=" + id + ", userId=" + userId + ", offer=" + offer + ", started=" + started
				+ ", status=" + status + ", sentIn=" + sentIn + "]";
	}
	
}
