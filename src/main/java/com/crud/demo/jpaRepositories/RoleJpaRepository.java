package com.crud.demo.jpaRepositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.demo.model.Role;

public interface RoleJpaRepository extends JpaRepository<Role,Integer>{

}
