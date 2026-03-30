package com.test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.TypedQuery;

public class StoreData {
	public static void main(String[] args)
	{
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session session= sf.openSession();
		Transaction t= session.beginTransaction();
		Student std1 = new Student();
		std1.setStd_name("Rohit");
		std1.setStd_college("BU");
		
		List<String> s1= Arrays.asList("Java", "Oracle", "Spring", "MutiSkills");
		std1.setSkills(s1);
		
		Student std2= new Student();
		
		std2.setStd_name("Virat");
		std2.setStd_college("MU");
		List<String> s2= Arrays.asList("Java", "Database");
		std2.setSkills(s2);
		
		session.persist(std1);
		session.persist(std2);
		
		t.commit();
		TypedQuery<Student> tq= session.createQuery("from Student");
			List<Student> list= tq.getResultList();
		Iterator<Student> itr= list.iterator();
		while(itr.hasNext())
		{
			Student std= itr.next();
			System.out.println(std.getId()+" "+std.getStd_name()+" "+std.getStd_college());
			List<String> skill=std.getSkills();
			skill.forEach(System.out::println);
		}
		session.close();
		System.out.println("Done.");
	}
}
