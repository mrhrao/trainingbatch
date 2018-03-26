package com.crud.demo.service.security.custom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.crud.demo.jpaRepositories.UserJpaRepository;
import com.crud.demo.model.User;
import com.crud.demo.model.security.custom.CustomUserDetails;

@Service
public class CustomUserService implements UserDetailsService {
	
	@Autowired
	private UserJpaRepository userJpaRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		UserDetails userDetails=null;
		User user=userJpaRepository.findByUserName(userName);
		if(user!=null)
		{
		userDetails=(UserDetails)user;
		}
		
		return userDetails;
	}

}
