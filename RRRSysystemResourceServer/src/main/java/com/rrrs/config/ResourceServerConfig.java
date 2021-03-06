package com.rrrs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfig {

	/*
	 * @Bean public TokenStore tokenStore() { return new
	 * JwtTokenStore(tokenConveter()); }
	 * 
	 * @Bean public JwtAccessTokenConverter tokenConveter() {
	 * JwtAccessTokenConverter conveter = new JwtAccessTokenConverter();
	 * conveter.setSigningKey("b$0l@123"); return conveter; }
	 */
}
