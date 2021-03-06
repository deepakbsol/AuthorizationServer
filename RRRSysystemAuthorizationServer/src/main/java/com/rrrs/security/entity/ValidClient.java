package com.rrrs.security.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "RRR_REGISTERED_CLIENT_DTLS")
public class ValidClient {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RRR_REGISTERED_CLIENT_DTLS_SEQ")
	@SequenceGenerator(name="RRR_REGISTERED_CLIENT_DTLS_SEQ", sequenceName = "RRR_REGISTERED_CLIENT_DTLS_SEQ",allocationSize = 1)
	@Column(name = "CLIENT_ID")
	private int clientId;
	@Column(name = "CLIENT",unique = true,length = 45,nullable = false)
	private String client;
	@Column(name = "SECRET",length = 500,nullable = false)
	private String secret;
	@Column(name = "SCOPE",length = 20)
	private String scope;
	@Column(name = "AUTHORIZED_GRANT_TYPE",length = 20)
	private String authorizedGrantType;
	public String getAuthorizedGrantType() {
		return authorizedGrantType;
	}
	public void setAuthorizedGrantType(String authorizedGrantType) {
		this.authorizedGrantType = authorizedGrantType;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public String getSecret() {
		return secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	
}
