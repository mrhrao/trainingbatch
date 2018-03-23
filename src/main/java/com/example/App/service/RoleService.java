package com.example.App.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.App.domain.Role;
import com.example.App.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository rolerepository;

	//========================OPERATIONS==========================
	
	
	public List<Role> getAllNotes(){
		return rolerepository.findAll();
	}



	public Role createrole(Role note) {
		return rolerepository.save(note);
	}
	
	
	/*public Register insertDataWithRole(@Valid @RequestBody Role note) {
		
		Register up=rolerepository.findOne(note.getId());
		up.getRoles().add(note);
		return rolerepository.save(up);
	}
	*/
	
	//========================OPERATIONS==========================
	

}
