package com.example.demo.services;

import static org.mockito.Mockito.never;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.roleDTO.RoleDTO;
import com.example.demo.dto.userDTO.ResetPasswordDTO;
import com.example.demo.model.userModel.RoleModel;
import com.example.demo.model.userModel.UserModel;
import com.example.demo.model.userModel.VerifyModel;
import com.example.demo.model.userModel.WalletModel;
import com.example.demo.repoINterface.RoleRepository;
import com.example.demo.repoINterface.UserRepository;
import com.example.demo.repoINterface.VerifyRepository;



@Service
public class UserServices {

	@Autowired
	UserRepository userData;
	
	@Autowired
	RoleRepository roleData;
	
	@Autowired
	MailServices mailServices;
	
	@Autowired 
	SmsServieces smsServieces;
	
	@Autowired
	VerifyRepository verifyData;
	public String saveUserData(UserModel data) {
		Random rand = new Random();
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		WalletModel walletModel=new WalletModel();
		long leftLimit = 1L;
	    long rightLimit = 10000000000L;
	    long randemId = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
	    walletModel.setRandemId(randemId);
	  	Format formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date today = Calendar.getInstance().getTime(); 
		String date = formatter.format(today);
		UserModel model=new UserModel();
		model.setCountry(data.getCountry());
		model.setEmail(data.getEmail());
		model.setMobileNo(data.getMobileNo());
		model.setId(data.getId());
		model.setPassword(passwordEncoder.encode(data.getPassword()));
		model.setUserName(data.getUserName());
		model.setStatus(data.isStatus());
		model.setCreatedOn(date);
		model.getWalletModel().add(walletModel);
		RoleModel role=roleData.findOneByUserRole("user");
		model.getRole().add(role);
		walletModel.setUserdata(model);
		UserModel checkData=userData.findOneByEmailAndMobileNo(data.getEmail(),data.getMobileNo());
		if(checkData!=null)
			return "error";
		userData.save(model);
		try {
			int otp=rand.nextInt(1000000);
			VerifyModel verify=new VerifyModel();
			verify.setTokenOtp(otp);
			verify.setUserName(model.getUserName());
			verify.setDate(date);
			verifyData.save(verify);
			mailServices.sendMail(data.getEmail(),otp);
			//smsServieces.sendSMS(otp);
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		return "success";
	}
	
	public List<UserModel> findAll()
	{
		return userData.findAll();
		
	}
	

	public String addRole(RoleModel data)
	{
		
		RoleModel model =roleData.findOneByUserRole(data.getUserRole());
	if(model==null)
		{
		roleData.save(data);
		return "success";
		}
	return "error";
		}
	
	public String addRoleToUser(RoleModel model) {
		UserModel user=userData.findOne(model.getId());
		RoleModel role=roleData.findOneByUserRole(model.getUserRole());
		if(user!=null&&role!=null)
		{
		user.getRole().add(role);
		userData.save(user);
		return "success";
		}
		return "error";
		
				
	}

	public List<RoleModel> findAllUserModel() {
		List<RoleModel> model2= roleData.findAll();
		return model2;
	}
	
	public List<RoleModel> findAllByUserModel(String data) {
		List<RoleModel> model2= roleData.findAllByUserRole(data);
		return model2;
	}
	
	public List<RoleDTO> findAllRole()
	{
		List<RoleModel> models=roleData.findAll();
		List<RoleDTO> data=new ArrayList<RoleDTO>();
		for(RoleModel model:models)
		{
			RoleDTO dto=new RoleDTO();
			dto.setId(model.getId());
			dto.setUserRole(model.getUserRole());
			data.add(dto);
		}
		return data;
	}
	//-----------------
	public UserModel userLogin(String email,String password)
	{
		return userData.findOneByEmailAndPassword(email, password);
	}
	//-------
	public UserModel resetPassword(ResetPasswordDTO resetdata)
	{
		UserModel user=userData.findOneByEmailAndPassword(resetdata.getEmail(), resetdata.getOldPassword());
		if(user!=null)
		{
			user.setPassword(resetdata.getNewPassword());
			userData.save(user);
		}
		return user;
		
	}
	//-verifyuser-----
	public String verifyUser(VerifyModel data)
	{
		VerifyModel verify=verifyData.findOneByUserNameAndTokenOtp(data.getUserName(),data.getTokenOtp());
		if(verify!=null)
		{
		verifyData.delete(verify.getId());
		return "success";
		}
		return "error";
	}
}

