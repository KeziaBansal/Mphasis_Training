package com.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class CriteriaDemo {
	
	public static void main(String[] args) {
	Configuration cfg=new Configuration();
	cfg.configure("hibernate.cfg.xml");
	SessionFactory sf = cfg.buildSessionFactory();
	Session session=sf.openSession();
	Transaction t = session.beginTransaction();
	CriteriaBuilder cb = session.getCriteriaBuilder();
	CriteriaQuery<Order> cq= cb.createQuery(Order.class);
	cq.distinct(true);
	Root<Order> rt = cq.from(Order.class);
	cq.select(rt);
	
	TypedQuery<Order> tq=session.createQuery(cq);
	List<Order> list=tq.getResultList();
	
	System.out.println(list);
}
}
