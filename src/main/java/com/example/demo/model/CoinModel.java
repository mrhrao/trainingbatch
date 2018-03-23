package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CoinModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int coinId;
	private String coinName;
	private String coinSymbol;
	private long initialCoinSupply;
	private float coinPrice;
	
	public int getCoinId() {
		return coinId;
	}
	public void setCoinId(int coinId) {
		this.coinId = coinId;
	}
	public String getCoinName() {
		return coinName;
	}
	public void setCoinName(String coinName) {
		this.coinName = coinName;
	}
	public String getCoinSymbol() {
		return coinSymbol;
	}
	public void setCoinSymbol(String coinSymbol) {
		this.coinSymbol = coinSymbol;
	}
	public long getInitialCoinSupply() {
		return initialCoinSupply;
	}
	public void setInitialCoinSupply(long initialCoinSupply) {
		this.initialCoinSupply = initialCoinSupply;
	}
	public float getCoinPrice() {
		return coinPrice;
	}
	public void setCoinPrice(float coinPrice) {
		this.coinPrice = coinPrice;
	}
	

}
