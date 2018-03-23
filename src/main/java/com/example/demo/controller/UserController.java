package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserModel;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/userdata")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/getAllDetailUser", method = RequestMethod.GET)
	public List<UserModel> getAllDetail(){
		return userService.getAllDetails();
	}
	
	@RequestMapping(value ="/adduser", method = RequestMethod.POST)
	public void add(@RequestBody UserModel user) {
		userService.addUser(user);
	}
	@RequestMapping(value ="/addwallet/{name}", method = RequestMethod.POST)
	public void addingAnotherWallet(@PathVariable(value = "name") String walletType,@RequestBody UserModel user) {
		userService.addAnotherWallet(user,walletType);
	}
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST) 
	public List<UserModel> update(@PathVariable(value = "id") Integer userId,
            @RequestBody UserModel userDetails) {
		System.out.println(userId+"-------------------------------------");
		return userService.updateUser(userId,userDetails);
		
	}
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.POST) 
	public UserModel getUser(@PathVariable(value = "id") Integer userId,
            @RequestBody UserModel userDetails) {
		System.out.println(userId+"-------------------------------------");
		return userService.getUser(userId,userDetails);
		
	}
	
	@RequestMapping(value = "/addamount/{amount}/{walletType}", method = RequestMethod.POST) 
	public void addAmount(@PathVariable(value = "amount") Float amount,@PathVariable(value = "walletType") String walletType,@RequestBody UserModel userDetails) {
			 userService.addAmountIntoWallet(userDetails,amount,walletType);
		
	}
	
	@RequestMapping(value = "/withdrawamount/{amount}/{walletType}", method = RequestMethod.POST) 
	public void withdrawAmount(@PathVariable(value = "amount") Float amount,@PathVariable(value = "walletType") String walletType,@RequestBody UserModel userDetails) {
			 userService.withdrawAmountFromWallet(userDetails,amount,walletType);
		
	}
	
	@RequestMapping(value = "/deleteuser/{id}", method = RequestMethod.DELETE)
	public void delete(Integer id) {
		userService.deleteUser(id);
	}
	

	@RequestMapping(value ="/show1", method = RequestMethod.POST)
	public Iterable<UserModel> getAllRole() {
		 return userService.getAll();
	}

	
	@RequestMapping(value ="/save1", method = RequestMethod.POST)
	public void updateRoleRequest(@RequestBody UserModel user){
		userService.saveUserRole(user);
	}
	
	@RequestMapping(value ="/saveWallet", method = RequestMethod.POST)
	public void updateWalletRequest(@RequestBody UserModel user){
		userService.saveUserWallet(user);
	}

}
