package com.crud.demo.conroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.demo.model.User;
import com.crud.demo.model.UserWallet;
import com.crud.demo.service.UserWalletService;

@RestController
public class UserWalletController {
	@Autowired 
	private  UserWalletService userWalletService;
	
	
	@RequestMapping("/create-wallet")
     public String createWallet(@RequestBody User user){
		
		
		return userWalletService.createWallet(user);
	}
 
	@RequestMapping("/withdraw-amount")
    public String withdrawAmount(@RequestBody UserWallet userWallet){
		
		return userWalletService.withdrawAmount(userWallet);
	}
	@RequestMapping("/deposit-amount")
    public String depositAmount(@RequestBody UserWallet userWallet){
			
		return userWalletService.depositAmount(userWallet);
	}
}
