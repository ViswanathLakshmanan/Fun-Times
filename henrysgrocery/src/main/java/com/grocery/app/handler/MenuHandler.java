package com.grocery.app.handler;

import java.util.Scanner;

import com.grocery.app.App;

public class MenuHandler {
	
	public static void selectMenu(int menu) {
		
		switch (menu) {
		case 1:
			System.out.println("Product");	
			ProductHandler ph = new ProductHandler();
			ph.displayProduct();			
			break;
		case 2:
			System.out.println("Discount");	
			DiscountHandler dh = new DiscountHandler();
			dh.displayDiscount();
			break;
		case 3: 
			BillingHandler bh = new BillingHandler();
			bh.keyInfo();
			break;
		case 4: 
			ReportHandler rh = new ReportHandler();
			rh.dailyReport();
			break;	
		case 5: 
			DateHandler dateh = new DateHandler();
			dateh.dateselection();
			break;	

		default:
			System.out.println("Type Id 1 to 5");
			//App.userMenu();
			break;
		}
		 Scanner in  = new Scanner(System.in);
	   
		System.out.println("Press '*' Goback to Main menu");
		while(true){
			String main = in.nextLine();
			if(main.equalsIgnoreCase("*")) {
				App.userMenu();
				break;
			}
			
		}
		
		
			
	}
	
	

}
