package com.cognixia.store.dao;

import java.util.List;

import com.cognixia.store.models.Product;

public interface ProductDao {
	
	public Product getByCode(String productCode);
	public List<Product> getAllProducts();
	public boolean createProduct(Product product);
	public boolean updateProduct(Product product);
	public boolean deleteProduct(String productCode);
}
