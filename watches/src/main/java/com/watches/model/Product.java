package com.watches.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Product {
	@Id
	private String productid;
	private String productname;
	private String productdesc;
	private boolean isproductavailable;
	private float rating;
	private int noitemssold;
	private int noreviews;
	@Transient 
	private MultipartFile imagefile;
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
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
	public boolean isIsproductavailable() {
		return isproductavailable;
	}
	public void setIsproductavailable(boolean isproductavailable) {
		this.isproductavailable = isproductavailable;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
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
	public MultipartFile getImagefile() {
		return imagefile;
	}
	public void setImagefile(MultipartFile imagefile) {
		this.imagefile = imagefile;
	}
	
	
	

}
