package com.revature.ndfinancial.retail.model;

import java.util.List;

public class Specials {
	private List<Special> results;

	public List<Special> getResults() {
		return results;
	}

	public void setResults(List<Special> results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return "Specials [results=" + results + "]";
	}
	
}
