package com.watches.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class CartItem implements Serializable{
	@Id
	private String cartitemid;
	private int quantity;
	private int itemwisetotal;
	
	
	@ManyToOne
	@JoinColumn(name="cartid")
	private Cart cart;
	
	@ManyToOne
	@JoinColumn(name="psid")
	private XMAP_Product_Supplier xmap_product_supplier;

	public XMAP_Product_Supplier getXmap_product_supplier() {
		return xmap_product_supplier;
	}

	public void setXmap_product_supplier(XMAP_Product_Supplier xmap_product_supplier) {
		this.xmap_product_supplier = xmap_product_supplier;
	}

	public String getCartitemid() {
		return cartitemid;
	}

	public void setCartitemid(String cartitemid) {
		this.cartitemid = cartitemid;
	}
	
	

	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getItemwisetotal() {
		return itemwisetotal;
	}

	public void setItemwisetotal(int itemwisetotal) {
		this.itemwisetotal = itemwisetotal;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

}
