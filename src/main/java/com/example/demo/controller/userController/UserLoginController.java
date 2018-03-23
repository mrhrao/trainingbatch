package com.example.demo.controller.userController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.userDTO.LoginDTO;
import com.example.demo.dto.userDTO.ResetPasswordDTO;
import com.example.demo.model.userModel.UserModel;
import com.example.demo.services.UserServices;

@RestController
public class UserLoginController {
	
@Autowired
UserServices userData;
	
@RequestMapping(value="/userlogin",method=RequestMethod.POST)
public String userLogin(@RequestBody LoginDTO data)
{
	UserModel user=userData.userLogin(data.getEmail(),data.getPassword());
	if(user==null)
		return "error";
	
	return "success";
}
	

@RequestMapping(value="/resetpassword",method=RequestMethod.POST)
public String resetPassword(@RequestBody ResetPasswordDTO data)
{
	UserModel user=userData.resetPassword(data);
	if(user==null)
		return "error";
	
	return "success";
}
}
