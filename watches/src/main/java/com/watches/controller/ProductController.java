package com.watches.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.watches.model.Product;
import com.watches.service.ProductServiceInt;

@Controller
public class ProductController {
	@Autowired
	private ProductServiceInt productService;

@RequestMapping("/reqproduct")
public String dispalyproductpage(Model m)
{
	m.addAttribute("productobject", new Product());
	return "productpage";
}
@RequestMapping("/reqsendproductdata")
public String addproducttoDB(@ModelAttribute("productobject")Product p,Model m)
{
	p.setIsproductavailable(true);
	productService.addproduct(p);
	List<Product> productdata=productService.getAllProducts();
	m.addAttribute("products", productdata);
	System.out.println(productdata);
	return "displayproduct";
	
}
@RequestMapping("/reqDisplayProductsAdmin")
public String displayproduct(Model m)
{
	List<Product> productdata=productService.getAllProducts();
	m.addAttribute("products", productdata);
	return "displayproduct";
}
@RequestMapping("/reqDeleteProduct")
public String deleteProduct(@RequestParam("pid")String pid,Model m){
	
	productService.deleteProduct(pid);
	return "redirect:reqDisplayProductsAdmin";
}
@RequestMapping("/reqEditProduct")
public String editProductPage(@RequestParam("pid")String pid,Model m){
	// controller has to get complete object based on pid
	Product prd = productService.getProductById(pid);
	m.addAttribute("product", prd);
	return "editproduct";
}
@RequestMapping("/requpdateproductdata")
public String editProducttoDB(@ModelAttribute("product")Product prd){
	productService.editProduct(prd);
	return "redirect:reqDisplayProductsAdmin";
}
	
	
}
