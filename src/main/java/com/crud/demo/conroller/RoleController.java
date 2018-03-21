package com.crud.demo.conroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crud.demo.model.Role;
import com.crud.demo.service.RoleService;

@RestController
public class RoleController {
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value="/add-role",method=RequestMethod.POST)
	public void addUser(@RequestBody Role role) {
		System.out.println("controller hit");
		/*user.getRole().forEach(role->role.setUser(user));  important */
		
		roleService.addUserService(role);	
		
	}

}
