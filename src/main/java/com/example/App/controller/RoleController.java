package com.example.App.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.App.domain.Role;
import com.example.App.service.RoleService;

@RestController
@RequestMapping("/tranapi")
public class RoleController {


	@Autowired
	private RoleService roleservice;
	
	
	//========================CURD OPERATIONS==========================

	//show all role
	@RequestMapping(value="/role",method= RequestMethod.GET)
	public List<Role> showrole() {
		return roleservice.getAllNotes();
	}
	
	
	
	//create Role
		@RequestMapping(value = "/role", method = RequestMethod.POST)
			public Role createRole(@RequestBody Role note) {
				
				return roleservice.createrole(note);
			}
			
	/*//adding a new role
		@RequestMapping(value = "/adding", method = RequestMethod.POST)
		public Register add(@Valid @RequestBody Role role) {
			return roleservice.insertDataWithRole(role);
		}
*/

		//========================CURD OPERATIONS==========================
}
