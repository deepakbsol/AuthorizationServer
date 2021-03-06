package com.rrrs.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
@Component
public class CustomeAuthenticationProviderImp implements AuthenticationProvider{

	private UserDetailsService userDetailsService;
	private PasswordEncoder passwordEncoder;
	@Autowired
	public void setAuthenticationProvider(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}
	@Autowired
	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		final String username=authentication.getName();
		final String password=(String)authentication.getCredentials();
		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		System.out.println("auth provider");
		if(userDetails!=null && passwordEncoder.matches(password, userDetails.getPassword())){
			return new UsernamePasswordAuthenticationToken(username, password, userDetails.getAuthorities());
		}
		throw new BadCredentialsException("Bad Credentials. Please try with valid username and password");
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.equals(authentication);
	}

}
