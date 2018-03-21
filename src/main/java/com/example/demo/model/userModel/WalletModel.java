package com.example.demo.model.userModel;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class WalletModel {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)	
private long walletId;	
private int balance;
private int shadoBalance;
private String walletType;
public long getWalletId() {
	return walletId;
}
public void setWalletId(long walletId) {
	this.walletId = walletId;
}
public int getBalance() {
	return balance;
}
public void setBalance(int balance) {
	this.balance = balance;
}
public int getShadoBalance() {
	return shadoBalance;
}
public void setShadoBalance(int shadoBalance) {
	this.shadoBalance = shadoBalance;
}
public String getWalletType() {
	return walletType;
}
public void setWalletType(String walletType) {
	this.walletType = walletType;
}
}
