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
			System.out.println("Discount");	
			break;
		case 4: 
			System.out.println("Date change");	
			break;		

		default:
			System.out.println("Type Id 1 to 4");
			//App.userMenu();
			break;
		}
		 Scanner in  = new Scanner(System.in);
	     //System.out.println( "Enter the <<id>> to select the Menu Item");
	        
	       // int menu = in.nextInt();
		System.out.println("Press '*' Goback to Main menu");
		String main = in.nextLine();
		if(main.equalsIgnoreCase("*"))
			App.userMenu();
	}
	
	

}
