package com.watches.dao;

import com.watches.model.Cart;

public interface CartDaoInt {
	public abstract Cart getCart(String cartid); 
	public abstract int getCartSize(Cart cart);
	public abstract void updateCart(Cart cart);
}
