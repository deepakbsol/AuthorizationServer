package com.rrrs.security.dao;

import org.springframework.stereotype.Repository;

import com.rrrs.security.entity.ValidClient;

@Repository
public interface ClientDetailsDao {

	public ValidClient getValidClient(String client);

}
