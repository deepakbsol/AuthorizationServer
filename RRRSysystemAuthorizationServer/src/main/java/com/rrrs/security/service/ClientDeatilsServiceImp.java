package com.rrrs.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;

import com.rrrs.security.dao.ClientDetailsDao;
import com.rrrs.security.entity.ClientDetailsImp;
import com.rrrs.security.entity.ValidClient;

public class ClientDeatilsServiceImp implements ClientDetailsService {

	private ClientDetailsDao clientDetailsDao;
	@Autowired
	private void setClientDetailsDao(ClientDetailsDao clientDetailsDao) {
		this.clientDetailsDao=clientDetailsDao;
	}
	@Override
	public ClientDetails loadClientByClientId(String client) throws ClientRegistrationException {
		ValidClient validClient= clientDetailsDao.getValidClient(client);
		System.out.println("c--"+validClient.getSecret());
		return new ClientDetailsImp(validClient);
	}

}
