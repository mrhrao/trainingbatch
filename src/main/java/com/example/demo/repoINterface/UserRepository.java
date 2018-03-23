package com.example.demo.repoINterface;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.userModel.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {
	
	
	UserModel findByUserName(String username);
	
//	@Query("select u from UserModel u left join fetch u.role")
//	public List<UserModel> findAll();
	public UserModel findByIdAndUserName(long id,String userName);
	public UserModel findOneByUserName(String name);
	public UserModel findOneByEmailAndPassword(String email,String password);
}
