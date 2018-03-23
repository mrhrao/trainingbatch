package com.example.App.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.App.domain.Wallet;
import com.example.App.exception.ResourceNotFoundException;
import com.example.App.repository.WalletRepository;
@Service
public class WalletService {
	
	@Autowired
	WalletRepository walletrepository;
	
	
	// Create a new Wallet
	public Wallet createwallet(Wallet wallet) 
	{
		return walletrepository.save(wallet) ;
	}


	public Wallet depositwallet(Long wallet_id,Wallet wallet) {
		Wallet  wall =walletrepository.findById(wallet_id).orElseThrow(() -> new ResourceNotFoundException("Note", "id", wallet_id));
		long newBalnce=wall.getBalance()+ wallet.getBalance();
		wall.setBalance(newBalnce);
		wall.setShadow_balance(newBalnce);
		return walletrepository.save(wall);
	}


	public Wallet withdrawallet(Long wallet_id, @Valid Wallet wallet) {
		Wallet  wall =walletrepository.findById(wallet_id).orElseThrow(() -> new ResourceNotFoundException("Note", "id", wallet_id));
		if(wall.getBalance()>=wallet.getBalance()||wallet.getBalance()!=0) 
		{
		long newBalnce=wall.getBalance()-wallet.getBalance();
		wall.setBalance(newBalnce);
		return walletrepository.save(wall);
		}
		return walletrepository.save(wall);
	}
	

}
