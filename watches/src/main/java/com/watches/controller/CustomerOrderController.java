package com.watches.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerOrderController {
	
	@RequestMapping("/order/{cartId}")
	public String displayCheckOut(@PathVariable("cartId")String cartId){
		System.out.println("\nCartid in checkout : " + cartId);
		return "redirect:/checkout?cartId="+cartId;
	}
	
}