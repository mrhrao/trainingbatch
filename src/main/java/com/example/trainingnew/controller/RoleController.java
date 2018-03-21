package com.example.trainingnew.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.trainingnew.model.Rolepojo;
import com.example.trainingnew.model.UserPojo;
import com.example.trainingnew.reprository.RoleRepo;
import com.example.trainingnew.reprository.UserRepo;

@RestController
@RequestMapping(value="/trainapi")
public class RoleController {
	
	@Autowired
	RoleRepo rolerepo;
	
	@Autowired
	UserRepo userrepo;
	
	@RequestMapping(value="/showrole",method= RequestMethod.GET)
	public List<Rolepojo> showrole() {
		return rolerepo.findAll();
	}
	
	
	//createRoledataServices
	@RequestMapping(value = "/insertrole", method = RequestMethod.POST)
		public Rolepojo createRole(@RequestBody Rolepojo note) {
			
			return rolerepo.save(note);
		}
	
	
	@RequestMapping(value = "/adding", method = RequestMethod.POST)
	public UserPojo insertDataWithRole(@Valid @RequestBody Rolepojo note) {
		
		UserPojo up=userrepo.findOneById(note.getId());
		up.getRoles().add(note);
		return userrepo.save(up);
	}
	
}
