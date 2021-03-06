package com.rrrs.security.dao;

import org.springframework.stereotype.Repository;

import com.rrrs.security.entity.ValidUser;

@Repository
public interface UserDetailsDao {

	public ValidUser getValidUser(String username);

}
