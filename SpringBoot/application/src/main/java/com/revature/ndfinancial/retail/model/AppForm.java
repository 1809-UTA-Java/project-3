package com.revature.ndfinancial.retail.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "appform")
public class AppForm {
	@Id
	@Column(name = "id")
	private String id;
	@Column(name = "userid")
	private String userId;
	@Column(name = "offer")
	private String offer;
	@Column(name = "started")
	private Date started;
	@Column(name = "status")
	private String status;
	@Column(name = "sentin")
	private Date sentIn;
	@Column(name = "active")
	private Boolean active;

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

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "AppForm [id=" + id + ", userId=" + userId + ", offer=" + offer + ", started=" + started + ", status="
				+ status + ", sentIn=" + sentIn + ", active=" + active + "]";
	}
}
