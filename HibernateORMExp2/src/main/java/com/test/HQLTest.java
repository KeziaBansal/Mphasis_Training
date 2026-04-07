package com.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HQLTest {
	public static void main(String[] args)
	{
//		Configuration cfg= new Configuration();
//		cfg.configure("hibernate.cfg.xml");
//		SessionFactory sf= cfg.buildSessionFactory();
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t= session.beginTransaction();
		// String hql="select o.o_name, o_quantity, o_price from Order o ";
//		OrderDao obj= new OrderDao();
//		Order obj1 = new Order();
//		
//		obj1.setO_name("Books");
//		obj1.setO_quantity(5);
//		obj1.setO_price(50);
//		session.persist(obj1);
//		t.commit();
		
		String hql1="delete from Order where id= :id";
		Query query=session.createQuery(hql1);
		query.setParameter("id", 102);
		query.executeUpdate();
		t.commit();
		
		String hql="from Order";
		Query<Order> q = session.createQuery(hql, Order.class);
		List<Order> list= q.getResultList();
		list.forEach(dt ->System.out.println(dt.getO_name()+" "+dt.getO_quantity()+" "+dt.getO_price()));
		
	}
}
