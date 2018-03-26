package com.crud.demo.jpaRepositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.demo.model.User;

public interface UserJpaRepository extends JpaRepository<User,Integer>{
	//use for security in custom security Service
	User findByUserName(String userName);

}
