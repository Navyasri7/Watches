package com.watches.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.watches.dao.CustomerDaoInt;
import com.watches.model.Customer;
import com.watches.model.UserDetails;
import com.watches.model.Vw_Prod_Supp_Xps;

@Service
public class CustomerServiceImp implements CustomerServiceInt {
	@Autowired
	private CustomerDaoInt customerDao;
	public String addCustomer(Customer cust) {
		
		return customerDao.addCustomer(cust);
	}
	public UserDetails loginCheck(UserDetails ud) {
	
		return  customerDao.loginCheck(ud);
	}
	public List<Vw_Prod_Supp_Xps> getProductsForUser() {
	
		return customerDao.getProductsForUser();
	}
	public List<Vw_Prod_Supp_Xps> getAllSuppProd(String pid) {
		
		return customerDao.getAllSuppProd(pid);
	}
	public Customer getCustomerByUserid(String uid) {
		// TODO Auto-generated method stub
		return customerDao.getCustomerByUserid(uid);
	}
	public Customer getCustomerByID(String custid) {
		// TODO Auto-generated method stub
		return customerDao.getCustomerByID(custid);
	}
	
	
	

}
