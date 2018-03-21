package com.example.demo.services;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.userModel.RoleModel;
import com.example.demo.model.userModel.UserModel;
import com.example.demo.repoINterface.RoleRepository;
import com.example.demo.repoINterface.UserRepository;



@Service
public class UserServices {

	@Autowired
	UserRepository userData;
	
	@Autowired
	RoleRepository roleData;
	
	public UserModel saveUserData(UserModel data) {
		
		Format formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date today = Calendar.getInstance().getTime(); 
		String date = formatter.format(today);
		UserModel model=new UserModel();
		model.setCountry(data.getCountry());
		model.setEmail(data.getEmail());
		model.setMobileNo(data.getMobileNo());
		model.setId(data.getId());
		model.setPassword(data.getPassword());
		model.setUserName(data.getUserName());
		model.setStatus(data.isStatus());
		model.setDate(date);
		return userData.save(model);
	}
	
	public List<UserModel> findAll()
	{
		return userData.findAll();
		
	}
	
	public List<RoleModel> findOneByUserName(String name)
	{
		
		UserModel model= userData.findOneByUserName(name);
		List<RoleModel> models=model.getRole();
		return models;
	}
	public void addRole(RoleModel data)
	{
		
		RoleModel model =roleData.findOneByUserRole(data.getUserRole());
	if(model==null)
		{
		roleData.save(data);
		}
		}
	
	public void addRoleToUser(RoleModel model) {
		UserModel user=userData.findOne(model.getId());
		RoleModel role=roleData.findOneByUserRole(model.getUserRole());
		user.getRole().add(role);
		role.getUser().add(user);
		userData.save(user);
				
	}

	public List<RoleModel> findAllUserModel() {
		List<RoleModel> model2= roleData.findAll();
		return model2;
	}
	
	public List<RoleModel> findAllByUserModel(String data) {
		List<RoleModel> model2= roleData.findAllByUserRole(data);
		return model2;
	}
	
}

