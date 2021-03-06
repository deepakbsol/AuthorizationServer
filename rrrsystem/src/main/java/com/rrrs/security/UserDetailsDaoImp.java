package com.rrrs.security;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public class UserDetailsDaoImp implements UserDetailsDao{
	@Autowired
	private EntityManager entityManager;
	@Autowired
	private DataSource dataSource;
	@Override
	public UserDetailsImp getUserDetails(String username) throws UsernameNotFoundException{
		
		System.out.println("username1-->"+dataSource);
		Session session = entityManager.unwrap(Session.class);
		System.out.println("entity manager--"+session);
		Query<ValidUser> createQuery = session.createQuery("from UserEntity where username=:username");
		createQuery.setParameter("username", username);
		ValidUser user = createQuery.getSingleResult();
		System.out.println("user-->"+user);
		return new UserDetailsImp(user);
	}
	
}
