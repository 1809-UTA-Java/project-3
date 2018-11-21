package com.revature.ndfinancial.retail.model;

import java.util.List;

public class AppForms {
	List<AppForm> result;

	public List<AppForm> getResult() {
		return result;
	}

	public void setResult(List<AppForm> result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "AppForms [result=" + result + "]";
	}
}
