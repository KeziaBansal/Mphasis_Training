package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InheritanceDemo {
	public static void main(String[] args)
	{
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session session= sf.openSession();
		Transaction t= session.beginTransaction();
		Vehicle vobj = new Vehicle();
		vobj.setV_name("Car");
		vobj.setLicenseNumber(123123);
		
		TwoWheeler tobj = new TwoWheeler();
		tobj.setV_name("Bike");
		tobj.setSteeringHandle("Bike Steering Handle");
		
		FourWheeler fobj= new FourWheeler();
		fobj.setV_name("Tesla");
		fobj.setSteeringWheel("AI Steering Wheel");
		
		session.persist(vobj);
		session.persist(tobj);
		session.persist(fobj);
		t.commit();
		System.out.println("Done.");
		
	}
}
