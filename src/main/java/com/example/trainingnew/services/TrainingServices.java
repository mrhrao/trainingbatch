package com.example.trainingnew.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.trainingnew.exception.ResourcesNotFoundException;
import com.example.trainingnew.model.UserPojo;
import com.example.trainingnew.reprository.RoleRepo;
import com.example.trainingnew.reprository.UserRepo;

@Service
public class TrainingServices {
	
	
	@Autowired
	UserRepo userrepo;
	
	@Autowired
	RoleRepo rolerepo;
	
	//getallServices
	public List<UserPojo> getAllData() {
		return userrepo.findAll();
	}
	
//	//createdataServices
	public UserPojo createData(UserPojo note) {
		return userrepo.save(note);
	}
		
	//getdatabyidServies
	public UserPojo getDataById(Long id) {
		return userrepo.findById(id).orElseThrow(()-> new ResourcesNotFoundException("Note", "Id", id));
	}
	
	//updateDataByidServices
	public UserPojo updateData(Long noteid,UserPojo noteDetails) {
		UserPojo note = userrepo.findById(noteid).orElseThrow(()-> new ResourcesNotFoundException("Note","id", noteid));
		note.setUsername(noteDetails.getUsername());
		note.setEmail(noteDetails.getEmail());
		note.setStatus(noteDetails.getStatus());
		note.setPassword(noteDetails.getPassword());
		UserPojo updatedNote = userrepo.save(note);
		return updatedNote;
	}
	
	//DeleteDataSevices
	public ResponseEntity<?> deletData(Long noteId) {
	    UserPojo note = userrepo.findById(noteId)
	            .orElseThrow(() -> new ResourcesNotFoundException("Note", "id", noteId));
	    userrepo.delete(note);
	    return ResponseEntity.ok().build();
	}

}
