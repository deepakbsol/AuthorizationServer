package com.rrrs.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.rrrs.security.dao.UserDetailsDao;
import com.rrrs.security.entity.UserDetailsImp;
import com.rrrs.security.entity.ValidUser;

public class UserDetailsServiceImp implements UserDetailsService{

	private UserDetailsDao userDetailsDao;
	@Autowired
	public void setUserDetailsDao(UserDetailsDao userDetailsDao) {
		this.userDetailsDao=userDetailsDao;
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("username--"+username);
		ValidUser validUser=userDetailsDao.getValidUser(username);
		System.out.println("valid "+validUser);
		return new UserDetailsImp(validUser);
	}

}
