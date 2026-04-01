package com.test.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.dao.ProductDao;
import com.test.entity.Product;
import com.test.repository.ProductRepository;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private ProductRepository repository;
	
	@Override
	public Product saveProduct(Product obj) {
		return repository.save(obj);
	}

	@Override
	public Product getProduct(int id) {
		return repository.findById(id).get();
	}

	@Override
	public Product updateProductById(Product obj) {
		return repository.save(obj);
	}

	@Override
	public List<Product> deleteProductsById(int id) {
		repository.deleteById(id);
		return repository.findAll();
	}

	@Override
	public List<Product> getAllProducts() {
		return repository.findAll();
	}

	@Override
	public List<Product> getProductsByName(String name) {
		return repository.getProductsByName(name);
	}

	@Override
	public List<Product> getProductsByQuantity(int qunty) {
		return repository.getProductsByQuantity(qunty);
	}

	@Override
	public List<Product> getProductsByNameQP(String name) {
		return repository.getProductsByNameQP(name);
	}

	@Override
	public List<Product> getProductsByQuantityQP(int qnty) {
		return repository.getProductsByQuantityQP(qnty);
	}

	@Override
	public List<Product> getAllProductsByNameASC() {
		return repository.getAllProductsByNameASC();
	}

}
