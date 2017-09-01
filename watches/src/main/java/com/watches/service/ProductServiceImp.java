package com.watches.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.watches.dao.ProductInt;
import com.watches.model.Product;
@Service
public class ProductServiceImp implements ProductServiceInt {
	@Autowired
	private ProductInt productDao;
	

	public void addproduct(Product p) {
		productDao.addproduct(p);
	}

	public List<Product> getAllProducts() {
		return productDao.getAllProducts();
	}

	public void deleteProduct(String pid) {
		productDao.deleteProduct(pid);
		
	}

	public Product getProductById(String pid) {
		return productDao.getProductById(pid);
	}

	public void editProduct(Product prd) {
		productDao.editProduct(prd);
		
	}
	


}
