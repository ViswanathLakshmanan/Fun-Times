package com.grocery.app.handler;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.grocery.app.model.Discount;

public class DiscountHandler {
	
	public static List<Discount> discountList = new ArrayList<>();
	
	public static void addAvailableDiscount() {
		
		Discount d1 = new Discount(1, 1, 2, 2,1 ,"per", 50,"Buy 2 tins of soup and get a loaf of bread half price");
		LocalDate fd1 = LocalDate.now().minusDays(1);
		LocalDate td1 = LocalDate.now().plusDays(5);
		d1.setFromDate(fd1);
		d1.setToDate(td1);
		
		
		
		Discount d2 = new Discount(2, 4, 1, 4,1, "per", 10,"Apples have a 10% discount");
		LocalDate fd2 = LocalDate.now().plusDays(2);
		LocalDate td2 = LocalDate.now().plusMonths(1).with(TemporalAdjusters.lastDayOfMonth());
	
		d2.setFromDate(fd2);
		d2.setToDate(td2);
		discountList.add(d1);
		discountList.add(d2);
		
		
		
	}
	
	
	public void displayDiscount() {		
					
		discountList.forEach(x -> {
			System.out.println("|---|---------------------------------------------------------|----------|-------|");
			System.out.println("|"+x.getId()+"  |"+ StringUtils.rightPad(x.getDiscountDesc(), 55) +"  |"+StringUtils.rightPad(x.getDiscountType(),7)+"   |"+StringUtils.rightPad(String.valueOf(x.getDicountVal()),5)+"  |");
			//System.out.println("---------------------------------------");
		});
		System.out.println("|---|---------------------------------------------------------|----------|-------|");
	}

}
