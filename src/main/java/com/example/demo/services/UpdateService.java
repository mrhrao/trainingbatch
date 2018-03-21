package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.userModel.UserModel;
import com.example.demo.repoINterface.UserRepository;

@Service
public class UpdateService {

	@Autowired
	UserRepository userData;
	public UserModel updateUserData(UserModel data)
	{
		UserModel model=new UserModel();
		model=userData.findByIdAndUserName(data.getId(), data.getUserName());
		model.setMobileNo(data.getMobileNo());
		model=userData.save(model);
		return model;
				
		
	}
}
