package com.grocery.app;

import java.time.LocalDate;
import java.util.Scanner;

import com.grocery.app.handler.DateHandler;
import com.grocery.app.handler.DiscountHandler;
import com.grocery.app.handler.MenuHandler;
import com.grocery.app.handler.ProductHandler;

/**
 * @author viswa
 * 
 *
 */
public class App 
{
	public static void userMenu() {
		System.out.println( "|Date     |"+DateHandler.currentDate +"    |");
        System.out.println( "|---------|--------------|");
        System.out.println( "|   ID    |"+"    MENU      |");
        System.out.println( "|---------|--------------|");
        System.out.println( "|<< 1 >>  |"+"  Product     |" );
        System.out.println( "|<< 2 >>  |"+"  Discount    |" );
        System.out.println( "|<< 3 >>  |"+"  Billing     |" );
        System.out.println( "|<< 4 >>  |"+"  Reports     |" );
        System.out.println( "|<< 5 >>  |"+"  Date Change |" );
        System.out.println( "----------|--------------|");
       
        Scanner in  = new Scanner(System.in);
        System.out.println( "Enter the <<id>> to select the Menu Item");
        int menu = 0;
        if(in.hasNextInt()) {
         menu = in.nextInt();
        }
        
              
        System.out.println( "Menu :" + menu);
        MenuHandler.selectMenu(menu);
      
}
    public static void main( String[] args )
    {
    	ProductHandler.addAvailableProduct();    	
    	DiscountHandler.addAvailableDiscount();
    	DateHandler.currentDate = LocalDate.now();
    	userMenu();
    }
}
