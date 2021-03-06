package com.rrrs.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.rsa.crypto.KeyStoreKeyFactory;

import com.rrrs.security.service.ClientDeatilsServiceImp;

@Configuration
@EnableAuthorizationServer
public class AuthorizationConfigClass extends AuthorizationServerConfigurerAdapter {

	private final AuthenticationManager authenticationManager;
	private final UserDetailsService userDetailsService;
	private final PasswordEncoder passwordEncoder;
	@Autowired
	public AuthorizationConfigClass(AuthenticationManager authenticationManager,PasswordEncoder passwordEncoder,
			UserDetailsService userDetailsService) {
		this.authenticationManager=authenticationManager;
		this.passwordEncoder=passwordEncoder;
		this.userDetailsService=userDetailsService;
	}
	@Bean
	public ClientDetailsService clientDatailsService() {
		return new ClientDeatilsServiceImp();
	}
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.withClientDetails(clientDatailsService());
		//clients.inMemory().withClient("client1").secret(passwordEncoder.encode("secret1")).scopes("read").authorizedGrantTypes("password");
	}
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authenticationManager);
		endpoints.userDetailsService(userDetailsService);
		endpoints.tokenStore(tokenStore());
		endpoints.accessTokenConverter(jwtTokenConveter());
	}
	
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.passwordEncoder(passwordEncoder);
		security.tokenKeyAccess("permitAll()");
		
	}
	@Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(jwtTokenConveter());
	}
	@Bean 
	public JwtAccessTokenConverter jwtTokenConveter() {
		JwtAccessTokenConverter accessTokenConveter = new JwtAccessTokenConverter();
		KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource("ssia.jks"), "ssia123".toCharArray());
		//accessTokenConveter.setSigningKey("b$0l@123");
		accessTokenConveter.setKeyPair(keyStoreKeyFactory.getKeyPair("ssia"));
		return accessTokenConveter;
	}
}
