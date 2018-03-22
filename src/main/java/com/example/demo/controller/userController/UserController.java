package com.example.demo.controller.userController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.userModel.RoleModel;
import com.example.demo.model.userModel.UserModel;
import com.example.demo.services.UserServices;



@RestController
public class UserController {
 
	
	@Autowired
	UserServices userservice;
	
	@RequestMapping(value="/hello",method=RequestMethod.POST)
	public RoleModel show(@RequestBody UserModel data)
	{
		userservice.saveUserData(data);
		System.out.println(addDataInRoleModel(data.getRole()));
		return addDataInRoleModel(data.getRole());
	}
	
	@RequestMapping(value="/addrole",method=RequestMethod.POST)
	public void addRole(@RequestBody RoleModel data)
	{
		
		userservice.addRole(data);
	}
	private RoleModel addDataInRoleModel(List<RoleModel> data)
	{
		
		RoleModel model=new RoleModel();
		for(RoleModel user1:data)
		{
			//model.setUserRole(user1.getUserRole());
			//System.out.print(user1.getUser());
		}
	
		return model;
	}
	@RequestMapping(value="/assignrole",method=RequestMethod.POST)
	public void AddRoleToUser(@RequestBody RoleModel data)
	{
		userservice.addRoleToUser(data);
	}

	
}