package com.crud.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.demo.jpaRepositories.RoleJpaRepository;
import com.crud.demo.jpaRepositories.UserJpaRepository;
import com.crud.demo.model.Role;
@Service
public class RoleService {
	@Autowired
	private UserJpaRepository userJpaRepository;
		@Autowired
		private RoleJpaRepository roleJpaRepository;
		
		
		
	public void addUserService(Role role) {
		
		roleJpaRepository.save(role);
		
	}

}
