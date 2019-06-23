package com.grocery.app.handler;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

import com.grocery.app.App;
import com.grocery.app.model.BilledProduct;
import com.grocery.app.model.Billing;
import com.grocery.app.model.Discount;
import com.grocery.app.model.DiscountedItem;
import com.grocery.app.model.Product;


public class BillingHandler {
	
	public static List<Billing> billingHolder = new LinkedList<>();
	
	public void keyInfo() {
		
		System.out.println("Enter '*' to Apply discount and bill submission");
		System.out.println("Enter '+' to Add basket item");
		Billing b = new Billing();
		b.setBillNo(billingHolder.size()+1);
		b.setBillDate(DateHandler.currentDate);
		List<BilledProduct> lstBilled = new ArrayList<>();
		NumberFormat formatter = new DecimalFormat("#0.00");
		Scanner in  = new Scanner(System.in);
		
		while(true)
		{
		String choice = in.nextLine();
		
		if(choice.equalsIgnoreCase("+")) {	
			BilledProduct bp = acceptBillItem(b, in,formatter);
			if(bp != null)
				lstBilled.add(bp);
			
		}
		else if(choice.equalsIgnoreCase("*")) {
			b.setBilledProduct(lstBilled);
			b.setDiscountedItem(normalizeBill(lstBilled,b));
			displayBill(b);
			billingHolder.add(b);
			break;
		}
		/*else {
			System.out.println("not valid");
		}*/
		}	
		
		
	}
	public void displayBill(Billing b) {
		NumberFormat formatter = new DecimalFormat("#0.00");   
		System.out.println("Bill No ::" + b.getBillNo() +"           Billdate  :"+b.getBillDate());
		b.getBilledProduct().stream().forEach( x -> {
			System.out.println("|---|------------|----------|-------|----------|-------|");
			System.out.println("|"+x.getId()+"  |"+ StringUtils.rightPad(x.getName(), 10) +"  |"+StringUtils.rightPad(x.getUnit(),7)+"   |"+StringUtils.rightPad(formatter.format(x.getPrice()),5)+"  |"
					+StringUtils.rightPad(String.valueOf(x.getQuantity()),7)+"   |"+StringUtils.rightPad(formatter.format(x.getAmount()),5)+"  |");
			
			
		});
		System.out.println("|---|------------|----------|-------|----------|-------|");
		
		b.getDiscountedItem().stream().forEach( y -> {
			System.out.println("|---------------------------------------------------------|----------|-------|");
			System.out.println("|"+ StringUtils.rightPad(y.getDiscountDesc(), 55) +"  |"+StringUtils.rightPad(String.valueOf(y.getDiscountApply()),7)+"   |"+StringUtils.rightPad(formatter.format(y.getDiscountAmount()),5)+"  |");
			
		});
		System.out.println("|---------------------------------------------------------|----------|-------|");
		
		b.setTotalAmount(b.getBillAmount()-b.getDiscountAmount());
		System.out.println("BillAmount ::" + formatter.format(b.getBillAmount()) +"           Discount  :"+formatter.format(b.getDiscountAmount())+ "      TotalAmount    : "+formatter.format(b.getTotalAmount()));
		
	}
	
	public BilledProduct acceptBillItem(Billing b,Scanner in,NumberFormat formatter) {
		
		 BilledProduct billedProduct = null;
		try {			
			
	        System.out.println( "Enter the Itemcode");
	        int procode = in.nextInt();
	        int qty;
		
        
        Product product= ProductHandler.productList.stream()
        	.filter(p ->p.getId() == procode).findFirst()
        	.orElseThrow(() -> new IllegalArgumentException("Item code not valid"));
        
        System.out.println( "Enter the Quantity in  "+product.getUnit()+" ");
         qty = in.nextInt();
        if(qty == 0) {
        	 System.out.println("incorrect entry");
        	 System.out.println( "Enter the Quantity in  "+product.getUnit()+" ");
        	 qty = in.nextInt();
        }
        
        double amount = calculateAmount(qty,product.getPrice());
        if(amount == 0) {
        	throw new IllegalArgumentException("incorrect entry");
        }
        
        
        b.setBillAmount(b.getBillAmount()+amount);
        System.out.println(product.getName()+"  price : "+ formatter.format(product.getPrice())
            +"  amount : "+formatter.format(amount) +" total : "+formatter.format(b.getBillAmount()) );
        billedProduct = new BilledProduct(product.getId(),
        		product.getName(),product.getUnit(),product.getPrice(),qty,amount);
		
        return billedProduct;
		}
		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return billedProduct;
			
		}
		
		
		
		
	}
	
	private double calculateAmount(int qty,double price) {
		
		double amount = qty*price;
		
		return amount;
		
	}
	
	
	public List<DiscountedItem> normalizeBill(List<BilledProduct> lstBilled,Billing b) {
		
		List<DiscountedItem> discitem = new ArrayList<>();
		Map<Integer,BilledProduct> hashMap = new HashMap<>();
		
		lstBilled.stream().forEach( x -> {

			if(hashMap.containsKey(x.getId())){
				BilledProduct exist = hashMap.get(x.getId());
				BilledProduct updated = new BilledProduct();
				updated.setId(x.getId());
				updated.setName(x.getName());
				updated.setPrice(x.getPrice());
				updated.setQuantity(exist.getQuantity()+x.getQuantity());
				updated.setAmount(exist.getAmount() + x.getAmount());
				updated.setUnit(x.getUnit());
			    hashMap.put(x.getId(), updated);
			}
			else {
			
				hashMap.put(x.getId(), x);
			}
					
		});
		
		
		hashMap.forEach( (k,v) -> {
			Discount d = DiscountHandler.discountList.stream().filter(p -> p.getDiscountFor() == k)
			.filter(p -> p.getFromDate().compareTo(b.getBillDate())<= 0
			&& p.getToDate().compareTo(b.getBillDate())>=0)
			.findAny().orElse(null);			
			if(d != null && v.getQuantity() >= d.getDiscountunit()) {
				if(hashMap.containsKey(d.getDiscountappliedOn()))
				{
					BilledProduct avail = hashMap.get(d.getDiscountappliedOn());
					int valcount =  v.getQuantity()/d.getDiscountunit();
					System.out.println("Valcount :: "+valcount);
					double discount;
					DiscountedItem di = new DiscountedItem();
					if(avail.getQuantity()>= valcount)
					{
						 discount = (valcount * avail.getPrice())* (d.getDicountVal()*0.01);
						 di.setDiscountApply(valcount);
					}
					else {
						discount = (avail.getQuantity() * avail.getPrice())* (d.getDicountVal()*0.01);
						di.setDiscountApply(avail.getQuantity());
					}
					di.setDiscountAmount(discount);
					di.setDiscountDesc(d.getDiscountDesc());
					discitem.add(di);
					b.setDiscountAmount(b.getDiscountAmount()+discount);
									
				}
			}
		});
		return discitem;
		
	
		
	}
	
	

}
