package com.grocery.app.model;

import java.time.LocalDate;

public class Discount {
	
	private int id;
	private int discountFor;
	private int discountunit;
	private int discountappliedOn;
	private String discountType;
	private double dicountVal;
	private LocalDate fromDate;
	private LocalDate toDate;
	private String discountDesc;
	
	public Discount(int id, int discountFor, int discountunit, int discountappliedOn, String discountType,
			double dicountVal,String discountDesc) {
		super();
		this.id = id;
		this.discountFor = discountFor;
		this.discountunit = discountunit;
		this.discountappliedOn = discountappliedOn;
		this.discountType = discountType;
		this.dicountVal = dicountVal;
		this.discountDesc = discountDesc;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDiscountFor() {
		return discountFor;
	}
	public void setDiscountFor(int discountFor) {
		this.discountFor = discountFor;
	}
	public int getDiscountunit() {
		return discountunit;
	}
	public void setDiscountunit(int discountunit) {
		this.discountunit = discountunit;
	}
	public int getDiscountappliedOn() {
		return discountappliedOn;
	}
	public void setDiscountappliedOn(int discountappliedOn) {
		this.discountappliedOn = discountappliedOn;
	}
	public String getDiscountType() {
		return discountType;
	}
	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}
	public double getDicountVal() {
		return dicountVal;
	}
	public void setDicountVal(double dicountVal) {
		this.dicountVal = dicountVal;
	}

	public LocalDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}

	public LocalDate getToDate() {
		return toDate;
	}

	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}

	public String getDiscountDesc() {
		return discountDesc;
	}

	public void setDiscountDesc(String discountDesc) {
		this.discountDesc = discountDesc;
	}


}
