package com.watches.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.watches.model.BillingAddress;
import com.watches.model.Cart;
import com.watches.model.Customer;
import com.watches.model.ShippingAddress;
import com.watches.model.UserDetails;
import com.watches.model.Vw_Prod_Supp_Xps;
import com.watches.service.CustomerServiceInt;

@Controller
public class CustomerController {
	@Autowired
	private CustomerServiceInt customerService;
	@RequestMapping("/reqLogout") //without spring secuurity
	public String logout(HttpSession hsession,Model m)
	{
		hsession.invalidate();
		String logoutMessage="Logged out successfilly";
		m.addAttribute("message", logoutMessage);
		return "homepage";
	}
	
	@RequestMapping("/reqLogoutSpring")  // spring security logout
	public String logoutSpring(HttpSession hsession,Model m){
		hsession.invalidate();
		String logoutMessage = "Logged out succcessfully.\nThanks for visiting our site...";
		m.addAttribute("message", logoutMessage);
		return "homepage";
	}
	@RequestMapping("/reqSignupPage")
	public String displaySignupForm(Model m) {
		UserDetails ud = new UserDetails();
		ShippingAddress sad = new ShippingAddress();
		Customer cust = new Customer();
		cust.setUserDetails(ud);
		cust.setShippingAddress(sad);
		m.addAttribute("customer", cust);
		return "signuppage1";
	}
	

	/*@RequestMapping("/reqSendSignupData")
	public String sendSignUpData(@ModelAttribute("customer") Customer cust, Model m) {

		cust.setEnabled(true);
		cust.getUserDetails().setUserrole("ROLE_USER");
		cust.getUserDetails().setEnabled(true);

		BillingAddress bad = new BillingAddress();
		bad.setHouseno(cust.getShippingAddress().getHouseno());
		bad.setStreet(cust.getShippingAddress().getStreet());
		bad.setArea(cust.getShippingAddress().getArea());
		bad.setCity(cust.getShippingAddress().getCity());
		bad.setState(cust.getShippingAddress().getState());
		bad.setCountry(cust.getShippingAddress().getCountry());
		bad.setPincode(cust.getShippingAddress().getPincode());

		Cart crt = new Cart();

		cust.setBillingAddress(bad);
		cust.setCart(crt);

		String userid = customerService.addCustomer(cust);
		String message = "Signup is successfull.\nNew User id : " + userid;
		m.addAttribute("signupmsg", message);
		m.addAttribute("userObject", new UserDetails());
		return "loginpage1";
	}*/
	@RequestMapping("/reqSendSignupData1") // with validation
	public String sendSignUpData1(@Valid @ModelAttribute("customer") Customer customer, BindingResult result, Model m) {
		if (result.hasErrors()) {
			System.out.println("\nerror");
			m.addAttribute("customer", customer);
			return "signuppage1";
		} 
		customer.setEnabled(true);
		customer.getUserDetails().setUserrole("ROLE_USER");
		customer.getUserDetails().setEnabled(true);

		BillingAddress bad = new BillingAddress();
		bad.setHouseno(customer.getShippingAddress().getHouseno());
		bad.setStreet(customer.getShippingAddress().getStreet());
		bad.setArea(customer.getShippingAddress().getArea());
		bad.setCity(customer.getShippingAddress().getCity());
		bad.setState(customer.getShippingAddress().getState());
		bad.setCountry(customer.getShippingAddress().getCountry());
		bad.setPincode(customer.getShippingAddress().getPincode());

		Cart crt = new Cart();

		customer.setBillingAddress(bad);
		customer.setCart(crt);

		String userid = customerService.addCustomer(customer);
		String message = "Signup is successfull.\nNew User id : " + userid;
		m.addAttribute("signupmsg", message);
		m.addAttribute("userObject", new UserDetails());
		return "loginpage1";
	}

	@RequestMapping("/reqLoginCheck")
	public String loginCheck(HttpSession hsession, @ModelAttribute("userObject") UserDetails ud, Model m) {
		UserDetails temp = customerService.loginCheck(ud);
		System.out.println(temp);
		if (temp == null) {// if authentication failed
			String message = "Login failed..,\nTry again...";
			m.addAttribute("userObject", new UserDetails());
			m.addAttribute("errormsg", message);
			return "loginpage1";
		} else if (temp.getUserrole().equals("ROLE_USER")) {			
			List <Vw_Prod_Supp_Xps> productsuser = customerService.getProductsForUser();
			hsession.setAttribute("customerprofile",customerService.getCustomerByUserid(temp.getUserid()));
			
			m.addAttribute("productsuser", productsuser);	
			return "userhomepage";
		} else {	
			
			hsession.setAttribute("adminprofile",customerService.getCustomerByUserid(temp.getUserid()));
			return "adminhomepage";
		}
	}
	@RequestMapping("/reqDisplayProductsUser")
	public String displayProductsUser(Model m, HttpSession hsession){
		Customer oldcust=(Customer) hsession.getAttribute("customerprofile");
		Customer newcust=customerService.getCustomerByID(oldcust.getCustomerid());
		hsession.setAttribute("customerprofile",newcust);
		List <Vw_Prod_Supp_Xps> productsuser = customerService.getProductsForUser();
		m.addAttribute("productsuser", productsuser);
		return "userhomepage";
	}
	@RequestMapping("/springLoginCheck") // comes here after spring security authenticates user
	public String loginCheck(Principal principal,HttpSession hsession,Model m){
		System.out.print("\nCustomerController - springLoginCheck()");
		System.out.println("\nName : " + principal.getName());
		Customer customer = customerService.getCustomerByUserid(principal.getName());
		UserDetails userDetials = customer.getUserDetails();
		System.out.println("\nRole : " + userDetials.getUserrole());

		if(userDetials.getUserrole().equals("ROLE_USER")){
			hsession.setAttribute("customerprofile", customer);
			return "redirect:/reqDisplayProductsUser";
		}
		else if(userDetials.getUserrole().equals("ROLE_ADMIN")){
			hsession.setAttribute("adminprofile", customer);
			return "adminHomePage1";
		}
		else 
			return "";
	}

	@RequestMapping("/reqProductAllSuppliers")
	public String getProductsAllSuppliers(@RequestParam("pid")String pid,Model m){
		List<Vw_Prod_Supp_Xps> allSupProd = customerService.getAllSuppProd(pid);
		m.addAttribute("allSupProd", allSupProd);
		return "productsAllSuppliers";
	}

}
