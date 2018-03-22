package com.example.adarsh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.adarsh.domain.Wallet;
import com.example.adarsh.repository.WalletRepository;

@Service

public class WalletService {

	@Autowired
	private WalletRepository walletRepository;

	public Wallet addWallet(Wallet wallet) {

		Wallet wallet1 = new Wallet();
		wallet1.setBalance(wallet.getBalance());
		wallet1.setRandomId(wallet.getRandomId());
		wallet1.setShadowBalance(wallet.getShadowBalance());
		wallet1.setWalletType(wallet.getWalletType());

		return walletRepository.save(wallet);
	}

	public Wallet depositMoney(Wallet wallet) {
		Wallet money = walletRepository.findOne(wallet.getId());
		int moneyBalance = money.getBalance() + wallet.getBalance();
		money.setBalance(moneyBalance);

		return walletRepository.save(money);
	}

	public Wallet withdrawMoney(int id, int balance) {

		Wallet money2 = walletRepository.findOne(id);
		int money2Balance = money2.getBalance();
		money2Balance = money2Balance - balance;
		money2.setBalance(money2Balance);
		money2.setShadowBalance(money2Balance);
		return walletRepository.save(money2);
	}

}
