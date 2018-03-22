package com.example.adarsh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.adarsh.domain.Wallet;
import com.example.adarsh.service.WalletService;

@RestController

public class WalletController {

	@Autowired
	private WalletService walletService;

	@RequestMapping(value = "/createWallet", method = RequestMethod.POST)
	public Wallet addWallet(@RequestBody Wallet wallet) {
		return walletService.addWallet(wallet);

	}

	@RequestMapping(value = "/deposit", method = RequestMethod.POST)
	public Wallet depositMoney(@RequestBody Wallet wallet) {
		return walletService.depositMoney(wallet);

	}

	@RequestMapping(value = "/withdraw", method = RequestMethod.POST)
	public Wallet withdrawMoney(@RequestParam int id, int balance) {
		return walletService.withdrawMoney(id, balance);

	}

}
