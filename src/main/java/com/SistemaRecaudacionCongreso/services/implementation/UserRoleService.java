package com.SistemaRecaudacionCongreso.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.SistemaRecaudacionCongreso.repositories.IUserRoleRepository;

@Service("userRoleService")
public class UserRoleService {
	
	@Autowired
	@Qualifier("userRoleRepository")
	public IUserRoleRepository userRoleRepository;
	
	public void saveUser(com.SistemaRecaudacionCongreso.entities.UserRole user) {
		userRoleRepository.save(user);
	}

}
