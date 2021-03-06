package com.rrrs.security.registerdao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rrrs.security.entity.ValidClient;
import com.rrrs.security.entity.ValidUser;

@Repository
public class RegisterUserAndClientDaoImp implements RegisterUserAndClientDao{

	private EntityManager entityManager;
	@Autowired
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	@Override
	public void saveUser(ValidUser user) {
		Session session = entityManager.unwrap(Session.class);
		Transaction transaction = session.beginTransaction();
		System.out.println("User id"+user);
		session.save(user);
		transaction.commit();
		session.close();
	}
	@Override
	public void saveClient(ValidClient validClient) {
		Session session = entityManager.unwrap(Session.class);
		Transaction transaction = session.beginTransaction();
		session.save(validClient);
		transaction.commit();
		session.close();
	}

}
