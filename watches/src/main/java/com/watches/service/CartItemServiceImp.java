package com.watches.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.watches.dao.CartItemDaoInt;
import com.watches.model.CartItem;
@Service
public class CartItemServiceImp implements CartItemServiceInt {

	@Autowired
	private CartItemDaoInt cartitemdao;

	public void addCartItem(CartItem cartItem) {
		cartitemdao.addCartItem(cartItem);
	}

	public CartItem getCartItem(String cartItemId) {
		return cartitemdao.getCartItem(cartItemId);
	}

	public void removeCartItem(String cartItemId) {
		cartitemdao.removeCartItem(cartItemId);
	}

	public void removeAllCartItems(String customerid) {
		cartitemdao.removeAllCartItems(customerid);
	}

}
