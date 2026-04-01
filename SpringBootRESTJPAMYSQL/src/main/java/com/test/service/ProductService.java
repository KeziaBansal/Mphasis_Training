package com.test.service;

import java.util.List;

import com.test.entity.Product;

public interface ProductService {
	public Product saveProduct(Product obj);
	public Product getProduct(int id);
	public Product updateProductById(Product obj);
	public List<Product> deleteProductsById(int id);
	public List<Product> getAllProducts();
	
	List<Product> getProductsByName(String name);
	List<Product> getProductsByQuantity(int qunty);
	List<Product> getProductsByNameQP(String name);
	List<Product> getProductsByQuantityQP(int qnty);
	List<Product> getAllProductsByNameASC();
}
