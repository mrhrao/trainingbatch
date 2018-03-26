package com.example.trainingnew.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_wallet")
public class Walletmodel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long wallet_id;
	private long user_id;
	private double balance;
	private double shadow_balance;
	private String wallet_type;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_wallet_fk", nullable = false)
	private Usermodel usermodel;

	public Usermodel getUsermodel() {
		return usermodel;
	}

	public void setUsermodel(Usermodel usermodel) {
		this.usermodel = usermodel;
	}

	public long getWallet_id() {
		return wallet_id;
	}

	public void setWallet_id(long wallet_id) {
		this.wallet_id = wallet_id;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getShadow_balance() {
		return shadow_balance;
	}

	public void setShadow_balance(double shadow_balance) {
		this.shadow_balance = shadow_balance;
	}

	public String getWallet_type() {
		return wallet_type;
	}

	public void setWallet_type(String wallet_type) {
		this.wallet_type = wallet_type;
	}

}
