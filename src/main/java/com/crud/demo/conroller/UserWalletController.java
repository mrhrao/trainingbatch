package com.crud.demo.conroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud.demo.model.User;
import com.crud.demo.model.UserWallet;
import com.crud.demo.service.UserWalletService;

@RestController
public class UserWalletController {
	@Autowired 
	private  UserWalletService userWalletService;
	
	
	@RequestMapping("/create-wallet")
     public void createWallet(@RequestBody User user){
		
		userWalletService.createWallet(user);	
	}
 
	@RequestMapping("/withdraw-amount")
    public void withdrawAmount(@RequestBody UserWallet userWallet){
		userWalletService.withdrawAmount(userWallet);	
	}
	/*@RequestMapping("/depoisit-amount")
    public void depositAmount(@RequestParam Integer userid,@RequestParam Float depositamount){
		userWalletService.depositAmount(userid,depositamount);	
	}*/
}
