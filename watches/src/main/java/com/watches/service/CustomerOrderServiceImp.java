package com.watches.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.watches.dao.CustomerOrderDaoInt;
import com.watches.model.CustomerOrder;
import com.watches.model.CustomerOrderHistory;

@Service
public class CustomerOrderServiceImp implements CustomerOrderServiceInt {

	@Autowired
	private CustomerOrderDaoInt customerOrderDao;

	public List<CustomerOrder> custOrders(String custid) {
		// TODO Auto-generated method stub
		return null;
	}

	public float getRating(String productid) {
		// TODO Auto-generated method stub
		return 0;
	}

	public CustomerOrderHistory getCustomerOrderHistoryByOrderHistoryId(String ordhistid) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getNoOfReviews(String productid) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getNoOfItemsSold(String productid) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void updateOrderHistory(CustomerOrderHistory coh) {
		// TODO Auto-generated method stub
		
	}
	

}
