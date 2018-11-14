package com.revature.ndfinancial.retail.model;

import java.util.Date;
import java.util.List;

public class Offer {
	private String id;
	private String desc;
	private String type;
	private double creditLimit;
	private double interestRate;
	private List<Special> incentives;
	private Date startDate;
	private Date endDate;
	private List<Group> target;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getCreditLimit() {
		return creditLimit;
	}
	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	public List<Special> getIncentives() {
		return incentives;
	}
	public void setIncentives(List<Special> incentives) {
		this.incentives = incentives;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public List<Group> getTarget() {
		return target;
	}
	public void setTarget(List<Group> target) {
		this.target = target;
	}
	@Override
	public String toString() {
		return "Offer [id=" + id + ", desc=" + desc + ", type=" + type + ", creditLimit=" + creditLimit
				+ ", interestRate=" + interestRate + ", incentives=" + incentives + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", target=" + target + "]";
	}
	
	
}
