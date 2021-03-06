package com.rrrs.security.registercontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rrrs.security.entity.ValidClient;
import com.rrrs.security.entity.ValidUser;
import com.rrrs.security.registerservice.RegisterUserAndClientService;

@RestController
@RequestMapping(value = "/api/register")
public class RegisterUserAndClientWithoutAuth {

	private  RegisterUserAndClientService registerUserAndClientService;
	private PasswordEncoder passwordEncoder;
	@Autowired
	public void setRegisterUserAndClientService(RegisterUserAndClientService registerUserAndClientService) {
		this.registerUserAndClientService=registerUserAndClientService;
	}
	@Autowired
	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
	@PostMapping(value = "/saveuser")
	public ValidUser saveUser(@RequestBody ValidUser user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		registerUserAndClientService.saveUser(user);
		return user;
	}
	@PostMapping(value = "/saveclient")
	public ValidClient saveClient(@RequestBody ValidClient validClient) {
		validClient.setSecret(passwordEncoder.encode(validClient.getSecret()));
		registerUserAndClientService.saveClient(validClient);
		return validClient;
	}
	@GetMapping("/test")
	public String test() {
		System.out.println("testing");
		return "tested !!";
	}
}
