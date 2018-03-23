package com.example.App.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.App.domain.Register;
import com.example.App.service.RegisterService;

@RestController
@RequestMapping("/tranapi")
public class RegisterController {
	
	@Autowired
	RegisterService registerservice;
	
	
   
	//========================CURD OPERATIONS==========================
	
	
	
    //get all data
    @RequestMapping(value="/notes",method=RequestMethod.GET)
	public List<Register> show() {
    	return registerservice.getAllNotes();
    }
     
    //save all data
    @RequestMapping(value="/notes",method=RequestMethod.POST)
	public Register saveuser(@Valid @RequestBody Register note) {
    	return registerservice.createNote(note);
    }
    
  //update data
   @RequestMapping(value="/notes/{id}",method=RequestMethod.PUT)
   public Register updatedata(@PathVariable(value = "id") Long noteId,
           @Valid @RequestBody Register noteDetails) {
	   System.out.println("hello");
	   return registerservice.updateNote(noteId,noteDetails);
	   
   }
   
    //delete data
    @RequestMapping(value="/notes/{id}",method=RequestMethod.DELETE)
    public ResponseEntity<?> deletedata(@PathVariable(value = "id") Long noteId) {
	  
    	return registerservice.deleteNote(noteId);
    }
   
    
    
    
 //========================CURD OPERATIONS==========================
}