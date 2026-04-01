package com.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.ProductDao;
import com.test.entity.Product;
import com.test.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao productDao;
	
	@Override
	public Product saveProduct(Product obj) {
		return productDao.saveProduct(obj);
	}

	@Override
	public Product getProduct(int id) {
		return productDao.getProduct(id);
	}

	@Override
	public Product updateProductById(Product obj) {
		return productDao.saveProduct(obj);
	}

	@Override
	public List<Product> deleteProductsById(int id) {
		return productDao.deleteProductsById(id);
	}

	@Override
	public List<Product> getAllProducts() {
		return productDao.getAllProducts();
	}

	@Override
	public List<Product> getProductsByName(String name) {
		return productDao.getProductsByName(name);
	}

	@Override
	public List<Product> getProductsByQuantity(int qunty) {
		return productDao.getAllProductsByNameASC();
	}

	@Override
	public List<Product> getProductsByNameQP(String name) {
		return productDao.getProductsByNameQP(name);
	}

	@Override
	public List<Product> getProductsByQuantityQP(int qnty) {
		return productDao.getProductsByQuantityQP(qnty);
	}

	@Override
	public List<Product> getAllProductsByNameASC() {
		return productDao.getAllProductsByNameASC();
	}

}
