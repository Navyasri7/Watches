package com.watches.service;

import com.watches.model.Cart;

public interface CartServiceInt {
	public abstract  Cart getCart(String cartid); 
	public abstract int getCartSize(Cart cart);
	public abstract void updateCart(Cart cart);

}
