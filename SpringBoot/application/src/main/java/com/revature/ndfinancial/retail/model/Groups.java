package com.revature.ndfinancial.retail.model;

import java.util.List;

public class Groups {
	private List<Group> results;

	public List<Group> getResults() {
		return results;
	}

	public void setResults(List<Group> results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return "Groups [results=" + results + "]";
	}
	
	
}
