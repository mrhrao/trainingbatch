package com.example.App.domain;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "wallet")
@EntityListeners(AuditingEntityListener.class)
public class Wallet {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long wallet_id;
	private long user_id;
	private long balance;
	private long shadow_balance;
	private String wallet_type;
	
	
	
	
	
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
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public long getShadow_balance() {
		return shadow_balance;
	}
	public void setShadow_balance(long shadow_balance) {
		this.shadow_balance = shadow_balance;
	}
	public String getWallet_type() {
		return wallet_type;
	}
	public void setWallet_type(String wallet_type) {
		this.wallet_type = wallet_type;
	}
	

}
