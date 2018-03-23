package com.example.adarsh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.adarsh.Dto.AssigneRole;
import com.example.adarsh.domain.Role;
import com.example.adarsh.domain.User;
import com.example.adarsh.repository.RoleRepository;
import com.example.adarsh.repository.UserRepository;
import com.example.adarsh.service.DataService;

@RestController
public class AuthController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	DataService dataService;

	@Autowired
	RoleRepository roleRepository;

	@GetMapping("/hello")
	public String string() {
		return "Hi Adarsh";

	}

	@RequestMapping(value = "/sign_up", method = RequestMethod.POST)
	public String saveUser(@RequestBody User user) {
		return dataService.saveUser(user);

	}

	@RequestMapping("/alluser")
	public List<User> getAllUser() {

		return dataService.getAllUsers();
	}

	@RequestMapping(value = "/add_role", method = RequestMethod.POST)
	public Role saveRole(@RequestBody Role role) {

		Role role2 = new Role();
		role2.setRoleName(role.getRoleName());
		return roleRepository.save(role2);
	}

	@RequestMapping(value = "/asignRole", method = RequestMethod.POST)
	public List<User> asignRole(@RequestBody AssigneRole assigneRole) {

		return dataService.asignRole(assigneRole);

	}

	@RequestMapping("/getbyRole")
	public List<User> getByRole(@RequestParam Long id) {
		return dataService.getByRole(id);
	}

}
