package com.grocery.app.model;

public class DiscountedItem {
	
	private int id;
	private String discountDesc;
	private int discountApply;
	private double discountAmount;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDiscountDesc() {
		return discountDesc;
	}
	public void setDiscountDesc(String discountDesc) {
		this.discountDesc = discountDesc;
	}
	public int getDiscountApply() {
		return discountApply;
	}
	public void setDiscountApply(int discountApply) {
		this.discountApply = discountApply;
	}
	public double getDiscountAmount() {
		return discountAmount;
	}
	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}

}
