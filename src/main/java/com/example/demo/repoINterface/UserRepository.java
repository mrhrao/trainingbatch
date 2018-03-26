package com.example.demo.repoINterface;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.userModel.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {
	
	
	UserModel findByUserName(String username);
	

	public UserModel findByIdAndUserName(Long id,String userName);
	public UserModel findOneByEmailAndMobileNo(String userName,String mobileNo);
	public UserModel findOneByUserName(String name);
	public UserModel findOneByEmail(String name);
	public UserModel findOneByUserNameAndEmailAndMobileNo(String userName,String email,String password);
	public UserModel findOneByEmailAndPassword(String email,String password);
}
