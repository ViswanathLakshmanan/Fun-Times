package com.grocery.app.model;

public class BilledProduct {
	
	
	private int id;	
	private String name;	
	private String unit;	
	private double price;	
	private int quantity;	
	private double amount;
	

	public BilledProduct() {
		super();
	}
	
	public BilledProduct(int id, String name, String unit, double price, int quantity, double amount) {
		super();
		this.id = id;
		this.name = name;
		this.unit = unit;
		this.price = price;
		this.quantity = quantity;
		this.amount = amount;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}	

}
