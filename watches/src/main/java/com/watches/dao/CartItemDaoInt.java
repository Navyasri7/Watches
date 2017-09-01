package com.watches.dao;

import com.watches.model.CartItem;

public interface CartItemDaoInt {
	
	public abstract void addCartItem(CartItem cartItem);
	public abstract CartItem getCartItem(String cartItemId);
    public abstract void removeCartItem(String CartItemId);
    public abstract void removeAllCartItems(String customerid);
}
