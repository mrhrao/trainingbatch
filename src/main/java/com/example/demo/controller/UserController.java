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
	public List<UserModel> getAllDetail() {
		return userService.getAllDetails();
	}

	// To add a new user and a default is created
	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public String add(@RequestBody UserModel user) throws Exception {
		userService.addUser(user);
		return "success";
	}

	@RequestMapping(value = "/addrole/{role}", method = RequestMethod.POST)
	public String addRoles(@PathVariable(value = "role") String roleType, @RequestBody UserModel user) {
		userService.addRole(user, roleType);
		return "success";
	}

	@RequestMapping(value = "/addwallet/{name}", method = RequestMethod.POST)
	public String addingAnotherWallet(@PathVariable(value = "name") String walletType, @RequestBody UserModel user) {
		userService.addAnotherWallet(user, walletType);
		return "success";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public List<UserModel> update(@PathVariable(value = "id") Integer userId, @RequestBody UserModel userDetails) {
		return userService.updateUser(userId, userDetails);
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.POST)
	public UserModel getUser(@PathVariable(value = "id") Integer userId, @RequestBody UserModel userDetails) {
		System.out.println(userId + "-------------------------------------");
		return userService.getUser(userId, userDetails);

	}

	@RequestMapping(value = "/addamount/{amount}/{walletType}", method = RequestMethod.POST)
	public String addAmount(@PathVariable(value = "amount") Float amount,
			@PathVariable(value = "walletType") String walletType, @RequestBody UserModel userDetails) {
		userService.addAmountIntoWallet(userDetails, amount, walletType);
		return "success";

	}

	@RequestMapping(value = "/withdrawamount/{amount}/{walletType}", method = RequestMethod.POST)
	public String withdrawAmount(@PathVariable(value = "amount") Float amount,
			@PathVariable(value = "walletType") String walletType, @RequestBody UserModel userDetails) {
		userService.withdrawAmountFromWallet(userDetails, amount, walletType);
		return "success";

	}

	@RequestMapping(value = "/deleteuser/{id}", method = RequestMethod.DELETE)
	public String delete(Integer id) {
		userService.deleteUser(id);
		return "success";
	}

	@RequestMapping(value = "/show1", method = RequestMethod.POST)
	public Iterable<UserModel> getAllRole() {
		return userService.getAll();
	}

	@RequestMapping(value = "/saveWallet", method = RequestMethod.POST)
	public String updateWalletRequest(@RequestBody UserModel user) {
		userService.saveUserWallet(user);
		return "success";
	}

}
