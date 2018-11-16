package com.revature.ndfinancial.retail.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;

public class Offer {
	@Id
	private String id;
	private String desc;
	private String type;
	private double creditLimit;
	private double interestRate;
	private List<String> incentives;
	private Date startDate;
	private Date endDate;
	private List<String> target;
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
	public List<String> getIncentives() {
		return incentives;
	}
	public void setIncentives(List<String> incentives) {
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
	public List<String> getTarget() {
		return target;
	}
	public void setTarget(List<String> target) {
		this.target = target;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public Offer(String desc, String type, double creditLimit, double interestRate, List<String> incentives,
			Date startDate, Date endDate, List<String> target, Boolean active) {
		super();
		this.desc = desc;
		this.type = type;
		this.creditLimit = creditLimit;
		this.interestRate = interestRate;
		this.incentives = incentives;
		this.startDate = startDate;
		this.endDate = endDate;
		this.target = target;
		this.active = active;
	}
	@Override
	public String toString() {
		return "Offer [id=" + id + ", desc=" + desc + ", type=" + type + ", creditLimit=" + creditLimit
				+ ", interestRate=" + interestRate + ", incentives=" + incentives + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", target=" + target + ", active=" + active + "]";
	}
	
	
}
