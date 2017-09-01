package com.watches.dao;

import java.util.List;

import com.watches.model.Product;

public interface ProductInt {
	void addproduct(Product p);
	List<Product> getAllProducts();
	public void deleteProduct(String pid);
	public Product getProductById(String pid);
	public void editProduct(Product prd);


}
