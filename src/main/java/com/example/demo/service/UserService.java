package com.example.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.constant.WalletEnum;
import com.example.demo.model.UserModel;
import com.example.demo.model.WalletModel;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.WalletRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private WalletRepository walletRepo;
	private static int id;
	
	
	public static int generateId() {
		Random randomNumber = new Random();
	    id = randomNumber.nextInt(100);
	    return id;
	}
	
	public void addWallet(UserModel userModel) {
		WalletModel walletModel = new WalletModel();
		walletModel.setUserIdW(userModel.getUserId());
		walletModel.setUserModel(userModel);
		walletModel.setWalletHash(generateId());
		walletRepo.save(walletModel);
	}
    public void addUser(UserModel userModel) {
    	userModel.setCreatedOn(new Date());
		userRepo.save(userModel);
		
		//Optional<UserModel> userOp = userRepo.findById(userModel.getUserId());
		addWallet(userModel);
		
		
	}
    public Boolean isWalletTypeValid(String walletType) {
    	int flag=0;
    	for (WalletEnum type : WalletEnum.values()) { 
    	    if(walletType.equalsIgnoreCase(type.toString())) {
    	    	flag=1;
    	    	break;
    	    }
    	}
    	if(flag==1) {
    		return true;
    	}
    	else {
    		return false;
    	}
    	
    }
   public void addAnotherWallet(UserModel userModel,String walletType) {
	  // System.out.println("Entering into the add "+"-----------------");
	  Boolean check= isWalletTypeValid(walletType);
	  if(check) {
		  
		  int flag=0;
		  List<WalletModel> walletOp=walletRepo.findAllByUserIdW(userModel.getUserId());
		//  System.out.println(walletOp+"-----------------");
		  for (WalletModel type :walletOp) { 
	    	   // System.out.println(type+"-------------list ---------------");
			  if(type.getWalletType().equalsIgnoreCase(walletType)) {
				  System.out.println(type.getWalletType());
				  flag=1;
				  break;
			  }
	    	}
		  if(flag==0) {
			  WalletModel walletModel = new WalletModel();
				walletModel.setUserIdW(userModel.getUserId());
				walletModel.setUserModel(userModel);
				walletModel.setWalletHash(generateId());
				walletModel.setWalletType(walletType);
				walletRepo.save(walletModel);
		  }
		
	  }
		
	}
   
   public void addAmountIntoWallet(UserModel userModel, Float amount, String walletType) {
		WalletModel walletModel = walletRepo.findByWalletTypeAndUserIdW(walletType,userModel.getUserId());
			  walletModel.setBalance(walletModel.getBalance()+amount);	
			  walletModel.setShadowBalance(walletModel.getBalance()+amount);	
			  walletRepo.save(walletModel);
   }
   public void withdrawAmountFromWallet(UserModel userModel, Float amount, String walletType) {
		WalletModel walletModel = walletRepo.findByWalletTypeAndUserIdW(walletType,userModel.getUserId());
			 if(amount<walletModel.getBalance()) {
		      walletModel.setBalance(walletModel.getBalance()-amount);	
			  walletModel.setShadowBalance(walletModel.getBalance()-amount);	
			  walletRepo.save(walletModel);
			  }
  }
  
	public List<UserModel> getAllDetails(){
		List<UserModel> userDetails = new ArrayList<UserModel>();
		userRepo.findAll().forEach(userDetails::add);
		return userDetails;
	}
	
	public void deleteUser(int id) {
		userRepo.deleteById(id);
	}
	
	public List<UserModel> updateUser(int userId,UserModel u)  {

		Optional<UserModel> userOp = userRepo.findById(userId);
		System.out.println(userOp+"---------------------------------------");
		userOp.get().setUserName(u.getUserName());
		userOp.get().setCountry(u.getCountry());
		userOp.get().setEmail(u.getEmail());
		userOp.get().setMobile(u.getMobile());
		userOp.get().setPasswd(u.getPasswd());
		
		userRepo.save(userOp.get());
		List<UserModel> userDetails = new ArrayList<UserModel>();
		userRepo.findAll().forEach(userDetails::add);
	    return userDetails;
	}
	
	
	
	public UserModel getUser(int userId,UserModel u)  {

		Optional<UserModel> userOp = userRepo.findById(userId);
	    return userOp.get();
	}

	
	public Iterable<UserModel> getAll(){
		return userRepo.findAll();
	}
	
	
	public void saveUserRole(UserModel user) {
		userRepo.save(user);		
		
	}
	
	public void saveUserWallet(UserModel user) {
		user.setCreatedOn(new Date());
		userRepo.save(user);		
		
	}
	
	

}
