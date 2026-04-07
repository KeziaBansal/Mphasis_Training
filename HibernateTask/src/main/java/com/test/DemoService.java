package com.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class DemoService {

    public void insertData() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();

        s.persist(new Employee("Alice", "IT"));
        s.persist(new Student("Bob", "MBA"));
        s.persist(new Student("Charlie", "BCA"));

        t.commit();
        s.close();
    }

    public List<Person> getAllUsingHQL() {
        Session s = HibernateUtil.getSessionFactory().openSession();

        List<Person> list =
                s.createQuery("from Person", Person.class)
                        .getResultList();

        s.close();
        return list;
    }

   
    public List<Person> getByNameUsingCriteria(String name) {
        Session s = HibernateUtil.getSessionFactory().openSession();

        CriteriaBuilder cb = s.getCriteriaBuilder();
        CriteriaQuery<Person> cq = cb.createQuery(Person.class);

        Root<Person> root = cq.from(Person.class);

        cq.select(root).where(cb.equal(root.get("name"), name));

        List<Person> list = s.createQuery(cq).getResultList();

        s.close();
        return list;
    }


    public List<Person> getUsingNamedQuery() {
        Session s = HibernateUtil.getSessionFactory().openSession();

        List<Person> list =
                s.createNamedQuery("Person.findAll", Person.class)
                        .getResultList();

        s.close();
        return list;
    }
}