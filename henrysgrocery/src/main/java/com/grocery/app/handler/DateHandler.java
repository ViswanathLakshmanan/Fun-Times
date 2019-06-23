package com.grocery.app.handler;

import java.time.LocalDate;
import java.util.Scanner;

public class DateHandler {
	
	public static LocalDate currentDate;
	
	void dateselection() {
		 Scanner in  = new Scanner(System.in);
	     System.out.println( "Type '1' for future date / '2' for past date");
	     int input = 0;
	     long days = 0;
	     if(in.hasNextInt()) {
	    	 input = in.nextInt();
	    	 
	    	 if(input == 1) {
	    		 System.out.println( "Type number of days you want to go further" );
	    		 days = in.nextLong();
	    	 }
	    	 if(input == 2) {
	    		 System.out.println( "Type number of days you want to go further" );
	    	 	days = in.nextLong();
	    	 }
	    	 
	     }
	     getDate(input, days);
	     displayDate();
	     
	}
	
	private void displayDate() {
		System.out.println("Date Selected   :  "+currentDate );
	}
	
	private void getCurrentDate() {
		currentDate = LocalDate.now();
		
	}
	
	private void futureDate(long daysToAdd) {
		currentDate = LocalDate.now().plusDays(daysToAdd);
	}
	
	private void pastDate(long daysToSubtract) {
		currentDate = LocalDate.now().minusDays(daysToSubtract);
	}
	
	private void getDate(int i,long days) {
		
		switch (i) {
		case 0:
			getCurrentDate();			
			break;
		case 1:
			futureDate(days);			
			break;
		case 2:
			pastDate(days);			
			break;

		default:
			System.out.println("Wrong Input system date selected");
			getCurrentDate();			
			break;
		}
	}

}
