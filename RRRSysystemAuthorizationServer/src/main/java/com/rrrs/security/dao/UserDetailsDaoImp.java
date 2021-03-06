package com.rrrs.security.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rrrs.security.entity.ValidUser;

@Repository
@Transactional
public class UserDetailsDaoImp implements UserDetailsDao{

	private EntityManager entityManager;
	@Autowired
	public UserDetailsDaoImp(EntityManager entityManager) {
		this.entityManager=entityManager;
	}
	@Override
	public ValidUser getValidUser(String username) {
		Session session = entityManager.unwrap(Session.class);
		Query <ValidUser> query = session.createQuery("from ValidUser where username=:username");
		query.setParameter("username", username);
		return query.getSingleResult();
	}

}
