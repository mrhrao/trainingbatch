package com.crud.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.demo.jpaRepositories.RoleJpaRepository;
import com.crud.demo.jpaRepositories.UserJpaRepository;
import com.crud.demo.model.Role;
import com.crud.demo.model.User;

@Service
public class UserService {
	@Autowired
private UserJpaRepository userJpaRepository;
	@Autowired
	private RoleJpaRepository roleJpaRepository;
	public void addUserService(User user) {
		user.setCreatedOn(new Date());
		userJpaRepository.save(user);
		
	}

	public User getUserByIdService(Integer id) {
		
		return userJpaRepository.findOne(id);
	}

	public List<User> getAllUserService() {
		
		return userJpaRepository.findAll();
	}

	public void updateUser(User user) {
		if(userJpaRepository.findOne(user.getId())!=null)
		{
		User existingUser=userJpaRepository.findOne(user.getId());
		  if(user.equals(existingUser)==false)
		  { 
			  for (Role role:existingUser.getRoles())
			  {   roleJpaRepository.delete(role);
				  roleJpaRepository.delete(role.getId());
				  
			  }
			  
			  existingUser.setUserName(user.getUserName());
			  existingUser.setPassword(user.getPassword());
			  existingUser.setEmail(user.getEmail());
			  existingUser.setPhoneNumber(user.getPhoneNumber());
			  existingUser.setStatus(user.getStatus());
			  existingUser.setCreatedOn(new Date());
			  existingUser.setRoles(user.getRoles());
			  
			  userJpaRepository.save(existingUser);}
		 }
		else
		{
			System.out.println("user does not exist");
		}
	}

	public void deleteUser(Integer id) {
		userJpaRepository.delete(id);	
		
	}
}
	
