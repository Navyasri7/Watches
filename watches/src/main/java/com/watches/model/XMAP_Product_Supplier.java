package com.watches.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class XMAP_Product_Supplier implements Serializable{
	@Id
private String psid;
private String productid;
private String supplierid;
private int productsupplierprice;
private int productsupplierstock;
private boolean isproductsupplieravailable;

@OneToMany(mappedBy="xmap_product_supplier",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
private List<CartItem> cartItems;

public String getPsid() {
	return psid;
}
public void setPsid(String psid) {
	this.psid = psid;
}
public List<CartItem> getCartItems() {
	return cartItems;
}
public void setCartItems(List<CartItem> cartItems) {
	this.cartItems = cartItems;
}
public String getProductid() {
	return productid;
}
public void setProductid(String productid) {
	this.productid = productid;
}
public String getSupplierid() {
	return supplierid;
}
public void setSupplierid(String supplierid) {
	this.supplierid = supplierid;
}
public int getProductsupplierprice() {
	return productsupplierprice;
}
public void setProductsupplierprice(int productsupplierprice) {
	this.productsupplierprice = productsupplierprice;
}
public int getProductsupplierstock() {
	return productsupplierstock;
}
public void setProductsupplierstock(int productsupplierstock) {
	this.productsupplierstock = productsupplierstock;
}
public boolean isIsproductsupplieravailable() {
	return isproductsupplieravailable;
}
public void setIsproductsupplieravailable(boolean isproductsupplieravailable) {
	this.isproductsupplieravailable = isproductsupplieravailable;
}


}
