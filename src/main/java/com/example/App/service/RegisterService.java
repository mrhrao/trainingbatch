package com.example.App.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.App.domain.Register;
import com.example.App.exception.ResourceNotFoundException;
import com.example.App.repository.RegisterRepository;

@Service
public class RegisterService {
	
	@Autowired
	RegisterRepository registerrepository;
	
	
	//========================OPERATIONS==========================
	
	
	public List<Register> getAllNotes(){
		return registerrepository.findAll();
	}
	
	public Register createNote(Register note) {
	    return registerrepository.save(note);
	}
	
	
	public Register updateNote(Long noteId,
             Register noteDetails) {

    Register note = registerrepository.findById(noteId).orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

       note.setUsername(noteDetails.getUsername());
       note.setEmail(noteDetails.getEmail());
       note.setPassword(noteDetails.getPassword());
       note.setStatus(noteDetails.getStatus());
       note.setCountry(noteDetails.getCountry());
       note.setPhoneNo(noteDetails.getPhoneNo());

     Register updatedNote = registerrepository.save(note);
     return updatedNote;
     }
	
	public ResponseEntity<?> deleteNote( Long noteId) {
	    Register note = registerrepository.findById(noteId).orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
	    registerrepository.delete(note);
	    return ResponseEntity.ok().build();
	}

	//========================OPERATIONS==========================
	
	
	}
	
