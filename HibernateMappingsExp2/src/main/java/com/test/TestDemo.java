package com.test;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestDemo {
	public static void main(String[] args) {
		Configuration cfg= new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf= cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		Order o1=new Order();
		o1.setO_name("Lifestyle");
		o1.setO_price("345");
		
		Order o2= new Order();
		o2.setO_name("Education");
		o1.setO_price("434");
		
		List<Order> list= Arrays.asList(o1, o2);
		User user = new User();
		user.setU_name("SKY");
		user.setOrder(list);
		session.persist(user);
		t.commit();
		System.out.println("Done.");
		session.close();
		
	}
}
