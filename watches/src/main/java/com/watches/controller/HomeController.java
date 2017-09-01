package com.watches.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.watches.model.UserDetails;
import com.watches.service.UserDetailsServiceInt;

@Controller
public class HomeController {
	@Autowired
	UserDetailsServiceInt userService;
@RequestMapping("/")
public String DisplayHomePage()
{
	return "homepage";
}
@RequestMapping("/reqlogin")
public String DisplayLogin(Model m)
{
	m.addAttribute("userObject", new UserDetails());
	return "loginpage1";
}
@RequestMapping("/reqLoginPage1")
public String loginPage1(@RequestParam(value="error", required=false)String error,Model m){
	if(error!=null){
		String message = "Login failed..,\nTry again...";
		m.addAttribute("errormsg", message);
	}
	return "springSecuityLoginPage";
}

@RequestMapping("/reqsignup")
private String DisplaySignUpPage(Model m)
{
 m.addAttribute("userObject", new UserDetails());
 return "signuppage";
 
}
@RequestMapping("/reqSendSignupdata")
public String DisplaySignUpData(@ModelAttribute("userObject")UserDetails ud,Model m){
//System.out.println("\nCntroller : " + ud.getUsername());	
	System.out.println(ud.getUserid());
	System.out.println(ud.getPassword());

 ud.setUserrole("ROLE_USER");

	ud.setEnabled(true);
	//userService.addUser(ud);
	String userid=userService.addUser(ud);
	String message = "Signup successfull. New user id : "+userid;
	m.addAttribute("signupmessage", message);
	m.addAttribute("userObject", new UserDetails());
	return "loginpage";

}
@RequestMapping("/reqSendLoginData")
public String loginCheck(@ModelAttribute("userObject")UserDetails ud,Model m){
	UserDetails temp = userService.loginCheck(ud);
	// if login is succes - loginsuccess
	// else display loginerror page
	System.out.println(temp);
	if(temp==null) { // authentication failed
		String errormessage = "Login failed. Try again...";
		m.addAttribute("errormessage", errormessage);
		m.addAttribute("userObject",new UserDetails());
		return "loginpage";
	}
	else if(temp.getUserrole().equals("ROLE_USER")){ // authentication success-user
		m.addAttribute("userdata", temp);
		return "loginsuccessuser";
	}
	else{
		m.addAttribute("userdata", temp);
		return "loginsuccessadmin";
	}
}


}
