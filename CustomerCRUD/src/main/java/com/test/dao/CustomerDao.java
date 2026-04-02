package com.test.dao;

import java.util.List;

import com.test.model.Customer;

public interface CustomerDao {
	public int saveCustomer(Customer obj);
	public List<Customer> listAllCustomers();
	
}
