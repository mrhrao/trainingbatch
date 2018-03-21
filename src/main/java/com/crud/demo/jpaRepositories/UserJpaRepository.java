package com.crud.demo.jpaRepositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.demo.model.User;

public interface UserJpaRepository extends JpaRepository<User,Integer>{

}
