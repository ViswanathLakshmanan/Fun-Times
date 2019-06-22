package com.grocery.app.handler;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.grocery.app.model.Product;

public class ProductHandler {
	
	public static List<Product> productList = new LinkedList();
	
	public static List<Product> searchproductList ;
	
	public static void addAvailableProduct() {
		
		Product p1 = new Product(1, "soup", "tin", 0.65);
		Product p2 = new Product(2, "bread", "loaf", 0.80);
		Product p3 = new Product(3, "milk", "bottle", 1.30);
		Product p4 = new Product(4, "apples", "single", 0.10);
		productList.add(p1);
		productList.add(p2);
		productList.add(p3);
		productList.add(p4);	
		
	}
	
	public static void searchProduct() {
		searchproductList = new ArrayList<Product>(productList);
	}
	
	public void displayProduct() {		
		NumberFormat formatter = new DecimalFormat("#0.00");     
				
		productList.forEach(x -> {
			System.out.println("|---|------------|----------|-------|");
			System.out.println("|"+x.getId()+"  |"+ StringUtils.rightPad(x.getName(), 10) +"  |"+StringUtils.rightPad(x.getUnit(),7)+"   |"+StringUtils.rightPad(formatter.format(x.getPrice()),5)+"  |");
			//System.out.println("---------------------------------------");
		});
			
		
	
		
	}
}
