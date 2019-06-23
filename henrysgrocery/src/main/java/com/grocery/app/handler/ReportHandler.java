package com.grocery.app.handler;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.apache.commons.lang3.StringUtils;

public class ReportHandler {
	
	NumberFormat formatter = new DecimalFormat("#0.00");  
	
	void dailyReport() {
		displayReport();
	}
	
	private void displayReport() {
		System.out.println("|BillNo | BillDate   | BillAmount| Discount | Totalamount |");
		System.out.println("|------ |------------|-----------|--------- | ----------- |");
		BillingHandler.billingHolder.stream().filter(p-> p.getBillDate().equals(DateHandler.currentDate)).forEach( x -> {
			System.out.println("|"+StringUtils.rightPad(String.valueOf(x.getBillNo()),7)+"|"+x.getBillDate()+" |"+ StringUtils.rightPad(formatter.format(x.getBillAmount()),10)+
					"|"+StringUtils.rightPad(formatter.format(x.getDiscountAmount()),10) +"|"+ StringUtils.rightPad(formatter.format(x.getTotalAmount()),10)+"|");
					//BillNo | BillDate   | BillAmount| Discount | Totalamount");
			
		});
		
	}

}
