package com.example.demo.repoINterface;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.userModel.RoleModel;

public interface RoleRepository extends JpaRepository<RoleModel, Long> {

	public RoleModel findOneByUserRole(String data);
	public List<RoleModel> findAllByUserRole(String data);

	
}
