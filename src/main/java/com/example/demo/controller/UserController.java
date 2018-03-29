package com.example.demo.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.RoleModel;
import com.example.demo.model.UserModel;
import com.example.demo.service.UserService;
import com.example.demo.utils.ApiResponse;

@RestController
@RequestMapping("/userdata")
public class UserController {

	@Autowired
	private UserService userService;

	// Get All User Detail
	@RequestMapping(value = "/getallusers", method = RequestMethod.GET)
	public ResponseEntity<Object> getAllDetail(HttpServletResponse httpResponse) {
		System.out.println(httpResponse.getStatus());

		Object obj = userService.getAllDetails();
		if (obj != null) {
			return ApiResponse.generateResponse(HttpStatus.OK, true, "success", obj);
		} else {
			return ApiResponse.generateResponse(HttpStatus.NOT_FOUND, false, "No data found", null);
		}

	}

	// To add a new user and a default is created
	@RequestMapping(value = "/signup", method = RequestMethod.POST, produces = { "application/JSON" })
	public ResponseEntity<Object> add(@RequestBody UserModel user) throws Exception {
		String response = userService.addUser(user);
		if (response.equalsIgnoreCase("success")) {
			return ApiResponse.generateResponse(HttpStatus.OK, true, "success", null);
		} else {
			return ApiResponse.generateResponse(HttpStatus.NOT_FOUND, false, "No data found", null);
		}

	}

	// To verify user
	@RequestMapping(value = "/verifyUser/{otp}", method = RequestMethod.POST)
	public ResponseEntity<ApiResponse> verifySignUp(@RequestBody UserModel user,
			@PathVariable(value = "otp") Integer otp) throws Exception {
		userService.verifyUser(user, otp);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Success..."), HttpStatus.OK);
	}

	// Add another role for user
	@RequestMapping(value = "/addrole/{role}", method = RequestMethod.POST)
	public ResponseEntity<ApiResponse> addRoles(@PathVariable(value = "role") String roleType,
			@RequestBody UserModel user) {
		userService.addAnotherRole(user, roleType);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Success..."), HttpStatus.OK);
	}

	// To fetch role
	@RequestMapping(value = "/fetchrole", method = RequestMethod.POST)
	public Set<RoleModel> fetchRoles(@RequestBody UserModel user) {
		Set<RoleModel> roleList = userService.fetchRole(user);
		return roleList;
	}

	// To fetch user
	@RequestMapping(value = "/fetchuser", method = RequestMethod.POST)
	public Set<UserModel> fetchUser(@RequestBody RoleModel role) {
		Set<UserModel> roleList = userService.fetchUser(role);
		return roleList;
	}

	// To add another wallet
	@RequestMapping(value = "/addwallet/{name}", method = RequestMethod.POST)
	public ResponseEntity<ApiResponse> addingAnotherWallet(@PathVariable(value = "name") String walletType,
			@RequestBody UserModel user) {
		userService.addAnotherWallet(user, walletType);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Success..."), HttpStatus.OK);
	}

	// To update user data
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public List<UserModel> update(@PathVariable(value = "id") Integer userId, @RequestBody UserModel userDetails) {
		return userService.updateUser(userId, userDetails);
	}

	// For user login
	@RequestMapping(value = "/userlogin", method = RequestMethod.POST)
	public UserModel getUser(@RequestBody UserModel userDetails) {
		// System.out.println(userId + "-------------------------------------");
		return userService.getUser(userDetails);

	}

	// To add amount into user wallet
	@RequestMapping(value = "/addamount/{amount}/{walletType}", method = RequestMethod.POST)
	public ResponseEntity<ApiResponse> addAmount(@PathVariable(value = "amount") Float amount,
			@PathVariable(value = "walletType") String walletType, @RequestBody UserModel userDetails) {
		userService.addAmountIntoWallet(userDetails, amount, walletType);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Success..."), HttpStatus.OK);
	}

	// To withdraw amount into user wallet
	@RequestMapping(value = "/withdrawamount/{amount}/{walletType}", method = RequestMethod.POST)
	public ResponseEntity<ApiResponse> withdrawAmount(@PathVariable(value = "amount") Float amount,
			@PathVariable(value = "walletType") String walletType, @RequestBody UserModel userDetails) {
		userService.withdrawAmountFromWallet(userDetails, amount, walletType);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Success..."), HttpStatus.OK);

	}

	// To delete amount into user wallet
	@RequestMapping(value = "/deleteuser/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<ApiResponse> delete(Integer id) {
		userService.deleteUser(id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Success..."), HttpStatus.OK);
	}
}
