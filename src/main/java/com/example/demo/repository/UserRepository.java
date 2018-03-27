package com.example.demo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.UserModel;

@Transactional
public interface UserRepository extends CrudRepository <UserModel,Integer>{
	//@Query("select u.userId form UserModel u, RoleModel m where m.role = u.role")
	public UserModel findByUserIdAndRoles(Integer id,String role);
	
}
