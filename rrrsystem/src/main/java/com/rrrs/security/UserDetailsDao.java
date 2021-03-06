package com.rrrs.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
@Repository
public interface UserDetailsDao {
 public UserDetails getUserDetails(String username) throws UsernameNotFoundException;
}
