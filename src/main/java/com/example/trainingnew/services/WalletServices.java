package com.example.trainingnew.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.trainingnew.exception.ResourcesNotFoundException;
import com.example.trainingnew.model.Walletmodel;
import com.example.trainingnew.reprository.WalletRepo;

@Service
public class WalletServices {
	
	
	@Autowired
	WalletRepo walletrepo;
	
	public Walletmodel createModel(Walletmodel wmodel) {
		return walletrepo.save(wmodel);
		
	}

	public Walletmodel depositwallet(Long wallet_id, Walletmodel wallet) {
		Walletmodel  wall =walletrepo.findById(wallet_id).orElseThrow(() -> new ResourcesNotFoundException("Note", "id", wallet_id));
		double newBalnce=wall.getBalance()+ wallet.getBalance();
		wall.setBalance(newBalnce);
		wall.setShadow_balance(newBalnce);
		return walletrepo.save(wall);
	}

	public Walletmodel withdrawallet(Long wallet_id, Walletmodel wallet) {
		Walletmodel  wall =walletrepo.findById(wallet_id).orElseThrow(() -> new ResourcesNotFoundException("Note", "id", wallet_id));
		if(wall.getBalance()>=wallet.getBalance()||wallet.getBalance()!=0) 
		{
		double newBalnce=wall.getBalance()-wallet.getBalance();
		wall.setBalance(newBalnce);
		return walletrepo.save(wall);
		}
		return walletrepo.save(wall);
	}


}
