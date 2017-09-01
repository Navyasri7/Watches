package com.watches.dao;

import com.watches.model.UserDetails;

public interface UserDetailsInt {
	public String addUser(UserDetails ud);
	public UserDetails loginCheck(UserDetails ud);

}
