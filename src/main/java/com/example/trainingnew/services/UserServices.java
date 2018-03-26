package com.example.trainingnew.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.trainingnew.exception.ResourcesNotFoundException;
import com.example.trainingnew.model.Rolemodel;
import com.example.trainingnew.model.Usermodel;
import com.example.trainingnew.reprository.RoleRepo;
import com.example.trainingnew.reprository.UserRepo;
import com.example.trainingnew.util.CustomErrorType;

@Service
public class UserServices {
	
	 public static final Logger logger = LoggerFactory.getLogger(UserServices.class);

	@Autowired
	UserRepo userrepo;

	@Autowired
	RoleRepo rolerepo;

	// getallServices
	public ResponseEntity<List<Usermodel>> getAllData() {
		List<Usermodel> find=userrepo.findAll();
		if(find.isEmpty())
		{
			return (new ResponseEntity(new CustomErrorType("No any data exist"), HttpStatus.NOT_FOUND));
		}
		
		return new ResponseEntity<List<Usermodel>>(find,HttpStatus.OK);
	}
	
//	@RequestMapping(value = "/user/", method = RequestMethod.POST)
//	public ResponseEntity<?> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
//		logger.info("Creating User : {}", user);
//
//		if (userService.isUserExist(user)) {
//			logger.error("Unable to create. A User with name {} already exist", user.getName());
//			return new ResponseEntity(new CustomErrorType("Unable to create. A User with name " + 
//			user.getName() + " already exist."),HttpStatus.CONFLICT);
//		}
//		userService.saveUser(user);
//
//		HttpHeaders headers = new HttpHeaders();
//		headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(user.getId()).toUri());
//		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
//	}

	 //createdataServices
	@SuppressWarnings("unchecked")
	public ResponseEntity<?> createData(Usermodel note) {
		
		Rolemodel rolemodel=rolerepo.findOneByRole("admin");
		
		Usermodel usermodel =new Usermodel();
		Usermodel umodel=userrepo.findOneByEmail(note.getEmail());
		
		if(umodel!=null){
			
			return new ResponseEntity(new CustomErrorType("This user "+note.getEmail()+" already exist"),
					HttpStatus.CONFLICT);
			
		}
		
		else {
			usermodel.setUsername(note.getUsername());
			usermodel.setEmail(note.getEmail());
			usermodel.setStatus(note.getStatus());
			usermodel.setPassword(note.getPassword());
			usermodel.setPhoneNo(note.getPhoneNo());
			usermodel.setCountry(note.getCountry());
			usermodel.setCreatedOn(note.getCreatedOn());
			usermodel.getRoles().add(rolemodel);
			
			userrepo.save(usermodel);
			return new ResponseEntity<Usermodel>(userrepo.save(usermodel),HttpStatus.OK);
		}
	}
		
		
//------------------------------------------------------------------------------------	
	// getdatabyidServies
	public ResponseEntity<?> getDataById(Long id) {
		Usermodel model=userrepo.findOneById(id);
		
		if(model==null)
		{
			return new ResponseEntity(new CustomErrorType("User with id "+id+" does not exist"),HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Usermodel>(model,HttpStatus.OK);
	}
//------------------------------------------------------------------------------------	

	// updateDataByidServices
	public ResponseEntity<?> updateData(Long noteid, Usermodel noteDetails) {
		Usermodel note = userrepo.findById(noteid)
				.orElseThrow(() -> new ResourcesNotFoundException("Note", "id", noteid));
		
		Usermodel note1 = userrepo.findOneById(noteid);
		if(note1==null)
		{
			return new ResponseEntity(new CustomErrorType("User with id "+noteid+" does not exist"),HttpStatus.NOT_FOUND);
		}
		else {		
		note.setUsername(noteDetails.getUsername());
		note.setEmail(noteDetails.getEmail());
		note.setStatus(noteDetails.getStatus());
		note.setPassword(noteDetails.getPassword());
		Usermodel updatedNote = userrepo.save(note);
		
		return new ResponseEntity<Usermodel>(updatedNote , HttpStatus.OK);
		}
	}
	
	
 
	// DeleteDataSevices
	public String deletData(Long noteId) {
		Usermodel note = userrepo.findOneById(noteId);
		
		if(note!=null) 
		{
			userrepo.delete(note);
			return note.getId()+" "+note.getUsername()+" Succesfully Deleted";
		}
		
		else 
		{
			return "OOps! userId doesn't exist";
		}
		
	}

}
