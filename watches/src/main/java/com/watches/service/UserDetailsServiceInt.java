package com.watches.service;

import com.watches.model.UserDetails;

public interface UserDetailsServiceInt {
	public String addUser(UserDetails ud);
	public UserDetails loginCheck(UserDetails ud);

}
