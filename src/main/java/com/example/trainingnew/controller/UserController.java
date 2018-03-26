package com.example.trainingnew.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.trainingnew.model.Usermodel;
import com.example.trainingnew.reprository.UserRepo;
import com.example.trainingnew.services.UserServices;


@RestController
@RequestMapping("/trainapi")
public class UserController {
	
	@Autowired
	UserServices services;
	
	@Autowired
	UserRepo userrepo;
	
	
	@RequestMapping("/hello")
	public String hello() {
		return "Hello World";
	}
	
	@RequestMapping("/secured/hello")
	@PreAuthorize("hasAnyRole('admin')")
	public String securedhello() {
		return "Secured Hello World";
	}
	
	public static final Logger logger = LoggerFactory.getLogger(UserController.class);

	//show all 
	@RequestMapping(value = "/showall", method = RequestMethod.GET)
	public ResponseEntity<List<Usermodel>> showData() {
		return services.getAllData();
	}
	
	//--------------------------------------------------------------------------

	// insert new data
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<?> insertData(@RequestBody Usermodel note ) {
		
		return services.createData(note);
	}
	
	//-------------------------------------------------------------------

	//get single data by id
	@RequestMapping(value="/show/{id}",method=RequestMethod.POST)
	public ResponseEntity<?> getById(@PathVariable(value="id") Long id) {
		return services.getDataById(id);		
	}
		
	//update a data with id
	@RequestMapping(value="/update/{id}",method=RequestMethod.PUT)
	public ResponseEntity<?> update(@PathVariable(value="id") Long id,@RequestBody Usermodel allDetails) {
		return services.updateData(id, allDetails);
	}
		
	//delete a note
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable(value="id") Long id){
		return services.deletData(id);
	}
	
	//==============================================================================
	
	//login api
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@RequestBody String email,String password) {
		
		System.out.println("Checking what values are coming "+email+" "+password);
		
//		Usermodel md=userrepo.findAllByEmail(email);
//			long checkid=md.getId();
		
		String mail="mohit";
		String passw="hello";
		
		if(email.equals(mail) && password.equals(passw))
		{
			return "Successfull Login";
		}
		
		else {
			return "Wrong Username and password";
			}
		
	}
	
		

}
