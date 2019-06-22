package com.grocery.app;

import java.util.Scanner;

import com.grocery.app.handler.MenuHandler;

/**
 * @author viswa
 * 
 *
 */
public class App 
{
	public static void userMenu() {
		 
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
        
        int menu = in.nextInt();
        
              
        System.out.println( "Menu :" + menu);
        MenuHandler.selectMenu(menu,in);
        /*
        int menu1 = in.nextInt();
        System.out.println( "Menu :" + menu1);*/
}
    public static void main( String[] args )
    {
    	userMenu();
    }
}
