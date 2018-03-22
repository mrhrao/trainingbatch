package com.crud.demo.service;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.demo.enums.wallet.WalletType;
import com.crud.demo.jpaRepositories.UserJpaRepository;
import com.crud.demo.jpaRepositories.UserWalletJpaRepository;
import com.crud.demo.model.User;
import com.crud.demo.model.UserWallet;

@Service
public class UserWalletService {
	int counter=0;
	@Autowired
	private UserWalletJpaRepository userWalletJpaRepository;
	@Autowired
	private UserJpaRepository userJpaRepository;
	
	
	
	public void createWallet(User user) 
	{
		User existingUser=userJpaRepository.findOne(user.getId());
		
		Set<UserWallet> setOfUserWallet=existingUser.getUserWallet();
		
		for (UserWallet userWalletObject:user.getUserWallet())
		{
			
			//wallet existing or not
			for (WalletType wall : WalletType.values()) 
			{  String wallstr=wall.toString();
				 if(wallstr.equalsIgnoreCase(userWalletObject.getWalletType())){
			     setOfUserWallet.add(userWalletObject);
				  counter++;
				  
				 }
				 
				}	
		}
		if(counter>0)
		{
		    existingUser.setUserWallet(setOfUserWallet);
		    existingUser.getUserWallet().forEach(wallet->wallet.setUser(user));//important
		    userJpaRepository.save(existingUser);
		}
	}

	public void withdrawAmount(UserWallet userWallet) {
		/*UserWallet existingUserWallet=userWalletJpaRepository.findByIdAndWalletType(userWallet.getWallet_id(), userWallet.getWalletType());
		System.out.println("::::::::::"+existingUserWallet);*/
		
		
	}

	/*public void depositAmount(Integer userid, Float depositamount) {
		// TODO Auto-generated method stub
		
	}*/

}
