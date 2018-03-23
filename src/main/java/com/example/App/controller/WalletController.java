package com.example.App.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.App.domain.Wallet;
import com.example.App.service.WalletService;

@RestController
@RequestMapping("/tranapi")
public class WalletController 
{
	
	@Autowired
	WalletService walletservice;
	
	// Create a new Wallet
	  //save all data
    @RequestMapping(value="/wallet",method=RequestMethod.POST)
	public Wallet createwallet(@Valid @RequestBody Wallet wallet) {
    	return walletservice.createwallet(wallet);
    }
    
    //Deposit into wallet
    @RequestMapping(value="/deposit/{id}",method=RequestMethod.PUT)
    public Wallet deposit(@PathVariable(value = "id") Long wallet_id,
            @Valid @RequestBody Wallet wallet) {
    	return walletservice.depositwallet(wallet_id,wallet);
    }
    
  //withdraw into wallet
    @RequestMapping(value="/withdraw/{id}",method=RequestMethod.PUT)
    public Wallet withdrw(@PathVariable(value = "id") Long wallet_id,
            @Valid @RequestBody Wallet wallet) {
    	return walletservice.withdrawallet(wallet_id,wallet);
    }

}
