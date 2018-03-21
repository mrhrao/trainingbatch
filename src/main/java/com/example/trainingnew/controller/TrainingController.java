package com.example.trainingnew.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.trainingnew.model.Rolepojo;
import com.example.trainingnew.model.UserPojo;
import com.example.trainingnew.reprository.UserRepo;
import com.example.trainingnew.services.TrainingServices;

@RestController
@RequestMapping("/trainapi")
public class TrainingController {
	
	@Autowired
	TrainingServices services;
	
	@Autowired
	UserRepo userrepo;

	//show all 
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public List<UserPojo> showData() {
		return services.getAllData();
	}

	// insert new data
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public UserPojo insertData(@Valid @RequestBody UserPojo note) {
		return services.createData(note);
	}
	
	//insert data with role
//	@RequestMapping(value = "/adding", method = RequestMethod.POST)
//	public UserPojo insertDataWithRole(@Valid @RequestBody Rolepojo note) {
//		
//		UserPojo up=userrepo.findOneById(note.getId());
//		up.getRoles().add(note);
//		return userrepo.save(up);
//	}

	//get single data by id
	@RequestMapping(value="/show/{id}",method=RequestMethod.POST)
	public UserPojo getById(@PathVariable(value="id") Long id) {
		return services.getDataById(id);
	}
		
	//update a data with id
	@RequestMapping(value="/update/{id}",method=RequestMethod.PUT)
	public UserPojo update(@PathVariable(value="id") Long id,@RequestBody UserPojo allDetails) {
		return services.updateData(id, allDetails);
	}
		
	//delete a note
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable(value="id") Long id){
		return services.deletData(id);
	}
		
		
}
