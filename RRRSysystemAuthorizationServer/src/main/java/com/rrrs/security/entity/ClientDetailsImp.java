package com.rrrs.security.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

public class ClientDetailsImp implements ClientDetails{

	private final ValidClient validClient;
	public ClientDetailsImp(ValidClient validClient) {
		this.validClient=validClient;
	}
	@Override
	public String getClientId() {
		return validClient.getClient();
	}

	@Override
	public boolean isSecretRequired() {
		return true;
	}

	@Override
	public String getClientSecret() {
		return validClient.getSecret();
	}

	@Override
	public boolean isScoped() {
		return true;
	}

	@Override
	public Set<String> getScope() {
		Set<String> scope=new HashSet<>();
		scope.add(validClient.getScope());
		return scope;
	}

	@Override
	public Set<String> getAuthorizedGrantTypes() {
		Set<String> auth=new HashSet<>();
		auth.add(validClient.getAuthorizedGrantType());
		return auth;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authority=new ArrayList<>();
		authority.add(new SimpleGrantedAuthority(validClient.getScope()));
		return authority;
	}

	@Override
	public Integer getAccessTokenValiditySeconds() {
		return null;
	}

	@Override
	public Integer getRefreshTokenValiditySeconds() {
		return null;
	}

	@Override
	public boolean isAutoApprove(String scope) {
		return false;
	}

	@Override
	public Set<String> getResourceIds() {
		return null;
	}


	@Override
	public Set<String> getRegisteredRedirectUri() {
		return null;
	}

	@Override
	public Map<String, Object> getAdditionalInformation() {
		return null;
	}

}
