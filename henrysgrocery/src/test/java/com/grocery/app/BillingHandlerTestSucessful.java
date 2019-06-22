package com.grocery.app;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.grocery.app.handler.BillingHandler;
import com.grocery.app.handler.DiscountHandler;
import com.grocery.app.model.BilledProduct;
import com.grocery.app.model.Billing;
import com.grocery.app.model.Discount;
import com.grocery.app.model.DiscountedItem;


public class BillingHandlerTestSucessful  {
	
 private static BillingHandler billingHandler;
	 
	    @BeforeClass
	    public static void initBillingHandler() {
	    	billingHandler = new BillingHandler();
	    }
	 
	    @Before
	    public void beforeEachTest() {
	        System.out.println("This is executed before each Test");
	    }
	 
	    @After
	    public void afterEachTest() {
	        System.out.println("This is exceuted after each Test");
	    }
	 
	    @Test
	    public void testNormalizeBill() {
	    	Billing b = new Billing();
	    	b.setBillNo(1);
	    	b.setBillDate(LocalDate.now());
	    	
	    	Discount d1 = new Discount(1, 1, 2, 2,1 ,"per", 50,"Buy 2 tins of soup and get a loaf of bread half price");
			LocalDate fd1 = LocalDate.now().minusDays(1);
			LocalDate td1 = LocalDate.now().plusDays(5);
			d1.setFromDate(fd1);
			d1.setToDate(td1);
			DiscountHandler.discountList.add(d1);
	    	
	    	List<BilledProduct> lstBilled = new ArrayList<>();
	    	BilledProduct bp1 = new BilledProduct();
	    	bp1.setId(1);
	    	bp1.setName("soup");
	    	bp1.setUnit("tin");
	    	bp1.setPrice(0.65);
	    	bp1.setQuantity(3);
	    	bp1.setAmount(1.95);
	    	lstBilled.add(bp1);
	    	BilledProduct bp2 = new BilledProduct();
	    	bp2.setId(2);
	    	bp2.setName("bread");
	    	bp2.setUnit("loaf");
	    	bp2.setPrice(0.80);
	    	bp2.setQuantity(2);
	    	bp2.setAmount(0.80);
	    	lstBilled.add(bp2);
	    	
	    	
	    	List<DiscountedItem> result = billingHandler.normalizeBill(lstBilled, b);
	       // int result = calculator.sum(3, 4);
	    	System.out.println("Result :::" +result.size());
	        //System.out.println("result.get(0).getDiscountAmount()  :: "+result.get(0).getDiscountAmount());
	        assertEquals(0.40, result.get(0).getDiscountAmount());
	    }
	 
	    
	 
	    /*@Test(expected = Exception.class)
	    public void testDivisionException() throws Exception {
	        calculator.divison(10, 0);
	    }*/
	 
	   
	
	
	
	

}
