package com.example.demo.services.deleteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.userModel.UserModel;
import com.example.demo.repoINterface.UserRepository;

@Service
public class DeleteService {

	@Autowired
	UserRepository userData;
	public void deleteById(String id)
	{
		UserModel model=new UserModel();
		long l=Long.valueOf(id);
		model.setId(l);
		userData.delete(model);
		
		}

}
