package com.grocery.app.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Billing {
	
	private int billNo;	
	private LocalDate billDate;	
	private double billAmount;	
	private double discountAmount;	
	private double totalAmount;
	
	private List<BilledProduct> billedProduct;
	
	private List<DiscountedItem> discountedItem;
	
	public int getBillNo() {
		return billNo;
	}

	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}

	
	public double getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}

	public double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<BilledProduct> getBilledProduct() {
		return billedProduct;
	}

	public void setBilledProduct(List<BilledProduct> billedProduct) {
		this.billedProduct = billedProduct;
	}

	public List<DiscountedItem> getDiscountedItem() {
		return discountedItem;
	}

	public void setDiscountedItem(List<DiscountedItem> discountedItem) {
		this.discountedItem = discountedItem;
	}

	public LocalDate getBillDate() {
		return billDate;
	}

	public void setBillDate(LocalDate billDate) {
		this.billDate = billDate;
	}

	
	

}
