package com.rrrs.security.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import com.rrrs.security.service.UserDetailsServiceImp;

@Configuration
public class AuthConfigClass extends WebSecurityConfigurerAdapter{

	private AuthenticationProvider authenticationProvider;
	@Autowired
	public void setAuthenticationProvider(AuthenticationProvider authenticationProvider) {
		this.authenticationProvider = authenticationProvider;
	}
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImp();
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic();
		http.csrf().disable();
		http.authorizeRequests()
		.mvcMatchers("/api/register/**").permitAll()
		.anyRequest().authenticated();
		
		http.cors(c->{
			CorsConfigurationSource cs= r->{
				CorsConfiguration cc=new CorsConfiguration();
				cc.setAllowedOrigins(List.of("*"));
				cc.setAllowedMethods(List.of("POST","GET"));
				cc.setAllowedHeaders(List.of("*"));
				return cc;
			};
			c.configurationSource(cs);
		});
	}
}
