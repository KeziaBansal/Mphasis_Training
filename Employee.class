package com.test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class TestDemo {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction t = session.beginTransaction();
		
		Address adr = new Address();
		
		adr.setCity("Bangalore");
		adr.setState("KA");
		
		Employee emp = new Employee();
		
		emp.setE_name("Rohit");
		
		emp.setE_company("PWC");
		
		emp.setAddress(adr);
		adr.setEmp(emp);
		
		session.persist(emp);
		
		t.commit();
		System.out.println("Done");
		
		session.close();

	}

}
