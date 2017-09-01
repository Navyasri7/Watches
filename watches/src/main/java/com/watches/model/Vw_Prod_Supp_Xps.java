package com.watches.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vw_Prod_Supp_Xps {
	@Id
	private String psid;
	private String productid;
	private String supplierid;
	private String suppliername;
	private String productname;
	private String productdesc;
	private int productsupplierprice;
	private int productsupplierstock;
	private double rating;
	private int noitemssold;
	private int noreviews;
	public String getPsid() {
		return psid;
	}
	public void setPsid(String psid) {
		this.psid = psid;
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
	public String getSuppliername() {
		return suppliername;
	}
	public void setSuppliername(String suppliername) {
		this.suppliername = suppliername;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getProductdesc() {
		return productdesc;
	}
	public void setProductdesc(String productdesc) {
		this.productdesc = productdesc;
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
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public int getNoitemssold() {
		return noitemssold;
	}
	public void setNoitemssold(int noitemssold) {
		this.noitemssold = noitemssold;
	}
	public int getNoreviews() {
		return noreviews;
	}
	public void setNoreviews(int noreviews) {
		this.noreviews = noreviews;
	}
	
	

}
