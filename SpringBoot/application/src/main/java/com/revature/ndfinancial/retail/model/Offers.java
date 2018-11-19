package com.revature.ndfinancial.retail.model;

import java.util.List;

public class Offers {
	private List<Offer> result;

	public List<Offer> getResult() {
		return result;
	}

	public void setResult(List<Offer> result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "Offers [result=" + result + "]";
	}
	
}
