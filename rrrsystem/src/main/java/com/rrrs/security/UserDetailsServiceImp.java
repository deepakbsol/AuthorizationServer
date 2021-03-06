package com.rrrs.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImp implements UserDetailsService{

	private  UserDetailsDao userDetailsDao;
	@Autowired
	public void setUserDetailsServiceImp(UserDetailsDao userDetailsDao) {
		this.userDetailsDao=userDetailsDao;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("username sent--"+username);
		return userDetailsDao.getUserDetails(username);
	}

}
