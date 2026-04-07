package com.test;

import java.util.List;

public class OrderDemo {
	public static void main(String[] args)
	{
		OrderDao odao = new OrderDao();
		Order obj = new Order();
		
//		obj.setO_name("Books");
//		obj.setO_quantity(5);
//		obj.setO_price(50);
		
		
//		obj.setO_name("Fruits");
//		obj.setO_quantity(10);
//		obj.setO_price(100);
		
		obj.setId(52);
		obj.setO_name("Vegetables");
		obj.setO_quantity(3);
		obj.setO_price(250);
		
		//obj.setId(102);
		obj.setO_name("Fruits");
		obj.setO_quantity(4);
		obj.setO_price(150);
		
		odao.saveOrder(obj);   // for creating record in the table
		// odao.updateOrder(obj); // for updating the record in the table
		
		//odao.deleteOrder(obj); // for deleting the record in the table
		
		List<Order> list= odao.listAllOrders();
		list.forEach(dt -> System.out.println(dt.getId()+" "+dt.getO_name()+" "+dt.getO_quantity()+" "+dt.getO_price()));
		
		
		System.out.println("Done.");
	}
}
