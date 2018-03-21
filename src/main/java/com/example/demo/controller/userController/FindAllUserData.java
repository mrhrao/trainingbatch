package com.example.demo.controller.userController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.userModel.RoleModel;
import com.example.demo.model.userModel.UserModel;
import com.example.demo.services.UserServices;

@RestController
public class FindAllUserData {

	@Autowired 
	UserServices userData;
	
	@RequestMapping(value="/showAll",method=RequestMethod.GET)
	@ResponseBody
	public List<UserModel> getAll(){
		return userData.findAll();
	}
	
	@RequestMapping(value="/showAllByRole",method=RequestMethod.GET)
	@ResponseBody
	private List<RoleModel> getall()
	{
		return userData.findAllUserModel();
	}
	
	@RequestMapping(value="/showAllByUserRole",method=RequestMethod.GET)
	@ResponseBody
	private List<RoleModel> getallUser(@RequestParam("userRole") String userRole)
	{
		return userData.findAllByUserModel(userRole);
	}


	@RequestMapping(value="/showRoleByUserName",method=RequestMethod.GET)
	@ResponseBody
	private List<RoleModel> getUserByRole(@RequestParam("userName") String userName)
	{
		return userData.findOneByUserName(userName);
	}
}
