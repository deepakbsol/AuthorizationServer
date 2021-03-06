package com.rrrs.security.registerservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rrrs.security.entity.ValidClient;
import com.rrrs.security.entity.ValidUser;
import com.rrrs.security.registerdao.RegisterUserAndClientDao;

@Service
public class RegisterUserAndClientServiceImp implements RegisterUserAndClientService{

	private RegisterUserAndClientDao registerUserAndClientDao;
	@Autowired
	public void setRegisterUserAndClientDao(RegisterUserAndClientDao registerUserAndClientDao) {
		this.registerUserAndClientDao = registerUserAndClientDao;
	}
	@Override
	public void saveUser(ValidUser user) {
		registerUserAndClientDao.saveUser(user);
	}
	@Override
	public void saveClient(ValidClient validClient) {
		registerUserAndClientDao.saveClient(validClient);
	}

}
