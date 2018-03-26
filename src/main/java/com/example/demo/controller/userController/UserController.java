package com.example.demo.controller.userController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.userModel.RoleModel;
import com.example.demo.model.userModel.UserModel;
import com.example.demo.model.userModel.VerifyModel;
import com.example.demo.repoINterface.VerifyRepository;
import com.example.demo.services.UserServices;



@RestController
public class UserController {
 
	
	@Autowired
	UserServices userservice;
	
	
	@RequestMapping(value="/addUser",method=RequestMethod.POST)
	public String show(@RequestBody UserModel data)
	{
		return userservice.saveUserData(data);
		}
	
	@PostMapping("/verifyuser")
	public String verifyUser(@RequestBody VerifyModel data)
	{
		return userservice.verifyUser(data);
	}
	
	
	@RequestMapping(value="/addrole",method=RequestMethod.POST)
	public String addRole(@RequestBody RoleModel data)
	{
		
		return userservice.addRole(data);
	}
		

	@RequestMapping(value="/assignrole",method=RequestMethod.POST)
	public String AddRoleToUser(@RequestBody RoleModel data)
	{
		return userservice.addRoleToUser(data);
	}

	
}