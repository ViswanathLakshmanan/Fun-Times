# Data-Model

Product
-------------
int id
String name
String unit
double price
--------------

Discount
---------------
int id
int discountfor
int discountunit
int discountappliedOn
String discountType(Flat,Per)
double dicountVal
String discountDesc
LocalDate fromDate;
LocalDate toDate;

Billing
----------------
int billNo; 
Date billDate; 
double billAmount; 
double discountAmount;
BilledItem  billedItem
DiscountItem discountItem
double totalAmount;


BilledItem
---------------
int id;	
String name;	
String unit;	
double price;	
double quantity;	
double amount;

DiscountItem
----------------
int id;
String discountDesc
int discountApply
double discountAmount

	







