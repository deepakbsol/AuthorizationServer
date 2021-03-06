package com.rrrs.security.registerdao;

import org.springframework.stereotype.Repository;

import com.rrrs.security.entity.ValidClient;
import com.rrrs.security.entity.ValidUser;

@Repository
public interface RegisterUserAndClientDao {

	void saveUser(ValidUser user);

	void saveClient(ValidClient validClient);

}
