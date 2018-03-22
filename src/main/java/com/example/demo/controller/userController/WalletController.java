package com.example.demo.controller.userController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.userModel.WalletModel;
import com.example.demo.services.WalletServices;

@RestController
public class WalletController {

	@Autowired
	WalletServices walletData;
	@RequestMapping(value="/addWallet",method=RequestMethod.POST)
	private WalletModel addWallet(@RequestBody WalletModel data)
	{
		return walletData.addWalletToUser(data);
		
	}
	
	@RequestMapping(value="/addMonetInWallet",method=RequestMethod.POST)
	public WalletModel addMoneyInWallet(@RequestBody WalletModel data)
	{
		return walletData.AddMoneyInWallet(data);
	}
	
	@RequestMapping(value="/withdrawMonetInWallet",method=RequestMethod.POST)
	public WalletModel withdrawMoneyInWallet(@RequestBody WalletModel data)
	{
		return walletData.withdrawMoneyInWallet(data);
	}
}
