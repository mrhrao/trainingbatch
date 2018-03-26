package com.example.trainingnew.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.trainingnew.model.Walletmodel;
import com.example.trainingnew.services.WalletServices;

@RestController
public class WalletController {
	
	@Autowired
	WalletServices services;
	
	@RequestMapping(value="/createwallet",method=RequestMethod.POST)
	public Walletmodel createWallet(@RequestBody Walletmodel mode) {
		return services.createModel(mode);
	}
	
    @RequestMapping(value="/deposit/{id}",method=RequestMethod.PUT)
    public Walletmodel deposit(@PathVariable(value = "id") Long wallet_id,
             @RequestBody Walletmodel wallet) {
    	return services.depositwallet(wallet_id,wallet);
    }
    
  //withdraw into wallet
    @RequestMapping(value="/withdraw/{id}",method=RequestMethod.PUT)
    public Walletmodel withdrw(@PathVariable(value = "id") Long wallet_id,
             @RequestBody Walletmodel wallet) {
    	return services.withdrawallet(wallet_id,wallet);
    }
	
}
