package com.watches.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.watches.dao.UserDetailsInt;
import com.watches.model.UserDetails;
@Service
public class UserDetailsServiceImp implements UserDetailsServiceInt {
	@Autowired
	private UserDetailsInt userDetailsDao;
	public String addUser(UserDetails ud) {
		
		return userDetailsDao.addUser(ud);
	}
	public UserDetails loginCheck(UserDetails ud) {
		
		return  userDetailsDao.loginCheck(ud);
	}

}
