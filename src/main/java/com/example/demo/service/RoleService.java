package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.RoleModel;
import com.example.demo.repository.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepo;
	
	public List<RoleModel> getAllDetails(){
		List<RoleModel> roleDetails = new ArrayList<RoleModel>();
		roleRepo.findAll().forEach(roleDetails::add);
		return roleDetails;
	}
	public void addRole(RoleModel roleModel) {
		roleRepo.save(roleModel);
	}
	public void deleteUser(int id) {
		roleRepo.deleteById(id);
	}
	public void updateUser(String id, RoleModel model) {
		roleRepo.save(model);
	}

}
