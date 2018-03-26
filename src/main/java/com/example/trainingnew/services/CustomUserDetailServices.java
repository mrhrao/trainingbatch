package com.example.trainingnew.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.trainingnew.model.Usermodel;
import com.example.trainingnew.model.CustomUserDetails;
import com.example.trainingnew.reprository.UserRepo;

public class CustomUserDetailServices implements UserDetailsService{

	@Autowired
	private UserRepo userrepo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	
		Usermodel usermodel=userrepo.findOneByEmail(email);
		// TODO Auto-generated method stub
		return new CustomUserDetails(usermodel);
	}

}
