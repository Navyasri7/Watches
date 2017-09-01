package com.watches.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.Valid;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Customer  implements Serializable{
	@Id
	private String customerid;
	
	@NotEmpty(message="Customer Name can not be empty")
    private String customername;
	@NotEmpty(message="mailid can not be empty")
	private String mailid;
	@NotEmpty(message="mobileno can not be empty")

	private String mobileno;
	private boolean enabled;
	
	@Transient 
	private MultipartFile customerimage;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="userid")
	@Valid
	private UserDetails userDetails;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="shippingAddressid")
	@Valid
	private ShippingAddress shippingAddress;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="billingAddressid")
	private BillingAddress billingAddress;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cartid")
	private Cart cart;
	
	@OneToMany(mappedBy="customer",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<CustomerOrder> customerOrder;
		
	public String getCustomerid() {
		return customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}


	public String getMailid() {
		return mailid;
	}


	public void setMailid(String mailid) {
		this.mailid = mailid;
	}


	public String getMobileno() {
		return mobileno;
	}


	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}


	public boolean isEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	public MultipartFile getCustomerimage() {
		return customerimage;
	}


	public void setCustomerimage(MultipartFile customerimage) {
		this.customerimage = customerimage;
	}


	public UserDetails getUserDetails() {
		return userDetails;
	}


	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}


	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}


	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}


	public BillingAddress getBillingAddress() {
		return billingAddress;
	}


	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}


	public Cart getCart() {
		return cart;
	}


	public void setCart(Cart cart) {
		this.cart = cart;
	}


	public List<CustomerOrder> getCustomerOrder() {
		return customerOrder;
	}


	public void setCustomerOrder(List<CustomerOrder> customerOrder) {
		this.customerOrder = customerOrder;
	}


	


}
