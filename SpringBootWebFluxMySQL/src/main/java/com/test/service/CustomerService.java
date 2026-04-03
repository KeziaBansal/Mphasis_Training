package com.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.entity.Customer;
import com.test.repository.CustomerRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerService 
{
	@Autowired
	private CustomerRepository repository;
	
	public Mono<Customer> saveCustomer(Customer cst)
	{
		return repository.save(cst);
	}
	
	public Flux<Customer> getAllCustomers()
	{
		return repository.findAll();
	}
}
