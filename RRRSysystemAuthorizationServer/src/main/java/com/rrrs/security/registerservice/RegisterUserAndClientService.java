package com.rrrs.security.registerservice;

import org.springframework.stereotype.Service;

import com.rrrs.security.entity.ValidClient;
import com.rrrs.security.entity.ValidUser;

@Service
public interface RegisterUserAndClientService {

	void saveUser(ValidUser user);

	void saveClient(ValidClient validClient);

}
