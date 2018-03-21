package com.example.demo.repoINterface;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.userModel.RoleModel;

public interface RoleRepository extends JpaRepository<RoleModel, Long> {

	public RoleModel findOneByUserRole(String data);
	public List<RoleModel> findAllByUserRole(String data);
	
	@Query(value="select id,user_role from role",nativeQuery=true)
	public List<RoleModel> findAllRole();
	
	
}
