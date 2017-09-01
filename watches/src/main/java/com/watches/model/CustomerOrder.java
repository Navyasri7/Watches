package com.watches.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class CustomerOrder {
	@Id
	private String orderid;
		
	@ManyToOne
	@JoinColumn(name="customerid")
	private Customer customer;
	

	@OneToMany(mappedBy="customerOrder",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private List<CustomerOrderHistory> customerOrdersHistory;
	private String shippedAddress;
	private Date orderDate;
	
	
	public String getShippedAddress() {
		return shippedAddress;
	}

	public void setShippedAddress(String shippedAddress) {
		this.shippedAddress = shippedAddress;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<CustomerOrderHistory> getCustomerOrdersHistory() {
		return customerOrdersHistory;
	}

	public void setCustomerOrdersHistory(List<CustomerOrderHistory> customerOrdersHistory) {
		this.customerOrdersHistory = customerOrdersHistory;
	}

	


}
