package com.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import org.hibernate.query.Query;

public class OrderDao {
	public static SessionFactory getDBSessionF()
	{
		SessionFactory factory= null;
		try
		{
//			Configuration cfg = new Configuration();
//			cfg.configure("hibernate.cfg.xml");
//			factory = cfg.buildSessionFactory();
			
			factory=HibernateUtil.getSessionFactory();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return factory;
	}
	
	public void saveOrder(Order obj)
	{
		Session session = OrderDao.getDBSessionF().openSession();
		Transaction t = session.beginTransaction();
		session.persist(obj);
		t.commit();
		session.close();
	}
	
	public List<Order> listAllOrders()
	{
		Session session = OrderDao.getDBSessionF().openSession();
		// Transaction t = session.beginTransaction();
		Query<Order> q= session.createQuery("from Order", Order.class);
		List<Order> list=q.list();
		return list;
	}
	
	public void updateOrder(Order obj)
	{
		Session session = OrderDao.getDBSessionF().openSession();
		Transaction t= session.beginTransaction();
		Order dt= session.find(Order.class, obj.getId());
		dt.setO_name(obj.getO_name());
		dt.setO_quantity(obj.getO_quantity());
		dt.setO_price(obj.getO_price());
		
		session.persist(dt);
		t.commit();
		session.close();
		
	}
	
	public void deleteOrder(Order obj)
	{
		Session session = OrderDao.getDBSessionF().openSession();
		Transaction t= session.beginTransaction();
		session.remove(obj);
		t.commit();
		session.close();
		
	}
}
