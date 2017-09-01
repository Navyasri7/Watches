package com.watches.service;

import java.util.List;

import com.watches.model.Customer;
import com.watches.model.UserDetails;
import com.watches.model.Vw_Prod_Supp_Xps;

public interface CustomerServiceInt {
	public String addCustomer(Customer cust);
	public UserDetails  loginCheck(UserDetails cd);
	public List<Vw_Prod_Supp_Xps> getProductsForUser();
	public List<Vw_Prod_Supp_Xps> getAllSuppProd(String pid);
	public Customer getCustomerByUserid(String uid);
	public Customer getCustomerByID(String custid);
}


