package com.example.adarsh.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Wallet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Integer id;
	private Integer balance = 0;
	private Integer shadowBalance = 0;
	private String walletType;
	private Integer randomId;

	
	@ManyToOne
	private User user;
	
	
	public long getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public Integer getShadowBalance() {
		return shadowBalance;
	}

	public void setShadowBalance(Integer shadowBalance) {
		this.shadowBalance = shadowBalance;
	}

	public String getWalletType() {
		return walletType;
	}

	public void setWalletType(String walletType) {
		this.walletType = walletType;
	}

	public Integer getRandomId() {
		return randomId;
	}

	public void setRandomId(Integer randomId) {
		this.randomId = randomId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	

}
