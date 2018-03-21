package com.crud.demo.conroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.demo.model.User;
import com.crud.demo.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value="/add-user",method=RequestMethod.POST)
	public void addUser(@RequestBody User user) {
		System.out.println("controller hit");
    /*user.getRole().forEach(role->role.setUser(user));  important */
		
	userService.addUserService(user);	
		
	}
	
	@RequestMapping(value="/getByUserId")
	@ResponseBody
	public User getUserById(@RequestParam Integer id) {
		System.out.println("for fetch");
	User user=userService.getUserByIdService(id);	
	return user;	
	}
	
	@RequestMapping("/getallUsers")
	@ResponseBody
	public List<User> getAllUser() {
		
		return userService.getAllUserService();
	}
	
	@RequestMapping(value="/update-user",method=RequestMethod.POST)
	public void updateUserById(@RequestBody User user)
	{
		
		userService.updateUser(user);	
	}
	
	@RequestMapping("/delete-user")
	public void deleteUserById(@RequestParam Integer id)
	{
		
		userService.deleteUser(id);	
	}
}
