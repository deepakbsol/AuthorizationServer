package com.rrrs.security.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rrrs.security.entity.ValidClient;
@Repository
@Transactional
public class ClientDetailsDaoImp implements ClientDetailsDao{

	private final EntityManager entityManager;
	@Autowired
	public ClientDetailsDaoImp(EntityManager entityManager) {
		this.entityManager=entityManager;
	}
	@Override
	public ValidClient getValidClient(String client) {
		System.out.println("client 1--"+client);
		Session session = entityManager.unwrap(Session.class);
		System.out.println("client 2--"+client);
		Query<ValidClient> query = session.createQuery("from ValidClient where client=:client");
		query.setParameter("client",client);
		return query.getSingleResult();
	}

}
